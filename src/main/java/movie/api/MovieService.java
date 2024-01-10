package movie.api;

import movie.api.vo.*;
import movie.domain.*;
import movie.repository.WorkerRepository;
import movie.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MovieService {

    private final MovieRepository movieRepository;
    private final WorkerRepository workerRepository;
    private final ApiClient apiClient;

    @Value("${movie.api.key}")
    private String apiKey;

    @Autowired
    public MovieService(MovieRepository movieRepository, WorkerRepository workerRepository, ApiClient apiClient) {
        this.movieRepository = movieRepository;
        this.workerRepository = workerRepository;
        this.apiClient = apiClient;
    }

    public BoxOfficeResultVO getBoxOfficeResult() {
        String apiUrl = "http://kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchWeeklyBoxOfficeList.json?" +
                "key="+apiKey+ "&targetDt=20230701&weekGb=0&itemPerPage=10";
        return apiClient.callApi(apiUrl, BoxOfficeResultVO.class);
    }

    public SearchMovieInfoVO getMovieDetail(String movieCd) {
        String apiUrl = "http://www.kobis.or.kr/kobisopenapi/webservice/rest/movie/searchMovieInfo.json?"
                + "key="+ apiKey +"&movieCd="+movieCd;
        return apiClient.callApi(apiUrl, SearchMovieInfoVO.class);
    }

    public void saveMovies(BoxOfficeResultVO boxOfficeResultVO) {
        for (BoxOfficeVO movies: boxOfficeResultVO.getWeeklyBoxOfficeList()) {
            Movie movie = new Movie();

            SearchMovieInfoVO movieInfo = getMovieDetail(movies.getMovieCd());

            Date date = convertDateFormat(movies.getOpenDt());
            String genre = movieInfo.getGenres().stream().map(Genrevo::getGenreNm).collect(Collectors.toList()).get(0);
            movie.createMovie(movies.getMovieCd(), Genre.fromString(genre), movies.getMovieNm(),
                    date, Integer.parseInt(movieInfo.getShowTm()));

            movieRepository.save(movie);

            saveActors(movieInfo, movie);
            saveDirectors(movieInfo, movie);
        }
    }

    public void updateMovies() {
        BoxOfficeResultVO boxOfficeResult = getBoxOfficeResult();
        saveMovies(boxOfficeResult);
    }

    public void saveActors(SearchMovieInfoVO movieInfo, Movie movie) {

        List<String> actorStringList = movieInfo.getActors()
                .stream()
                .map(ActorVO::getPeopleNm)
                .collect(Collectors.toList());

        for (String actors: actorStringList) {
            MovieWorker movieWorker = new MovieWorker(movie);
            Actor actor = new Actor(actors);
            workerRepository.save(movieWorker,actor);
            actor.addMovieWorker(movieWorker);
        }
    }


    public void saveDirectors(SearchMovieInfoVO movieInfo, Movie movie) {

        Optional<String> firstDirectorName = movieInfo.getDirectors()
                .stream()
                .map(DirectorVO::getPeopleNm)
                .findFirst();

        if (firstDirectorName.isPresent()) {
            String directorName = firstDirectorName.get();
            MovieWorker movieWorker = new MovieWorker(movie);
            Director director = new Director(directorName);
            workerRepository.save(movieWorker,director);
            director.addMovieWorker(movieWorker);
        }
    }

    public Date convertDateFormat(String inputDate) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;

        try {
            date = dateFormat.parse(inputDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }
}
