package movie.api;

import movie.api.vo.Genrevo;
import movie.api.vo.BoxOfficeVO;
import movie.api.vo.SearchMovieInfoVO;
import movie.movieservice.domain.Genre;
import movie.movieservice.domain.Movie;
import movie.movieservice.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import movie.api.vo.BoxOfficeResultVO;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.stream.Collectors;

@Service
public class MovieService {

    private final MovieRepository movieRepository;
    private final ApiClient apiClient;

    @Value("${movie.api.key}")
    private String apiKey;

    @Autowired
    public MovieService(MovieRepository movieRepository, ApiClient apiClient) {
        this.movieRepository = movieRepository;
        this.apiClient = apiClient;
    }

    public BoxOfficeResultVO getBoxOfficeResult() {
        String apiUrl = "http://kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchWeeklyBoxOfficeList.json?" +
                "key="+apiKey+ "&targetDt=20230701&weekGb=0";
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
        }
    }

    public void updateMovies() {
        BoxOfficeResultVO boxOfficeResult = getBoxOfficeResult();
        saveMovies(boxOfficeResult);
    }

    public Date convertDateFormat(String inputDate) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        Date date = null;

        try {
            date = dateFormat.parse(inputDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return date;
    }
}
