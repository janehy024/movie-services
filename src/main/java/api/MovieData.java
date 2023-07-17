package api;

import com.fasterxml.jackson.databind.ObjectMapper;
import movie.movieservice.domain.Genre;
import movie.movieservice.domain.Movie;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import vo.BoxOfficeResultVO;
import vo.BoxOfficeVO;
import vo.SearchMovieInfoVO;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@RestController
public class MovieData {

    String key = "8594a1f6bad2800f63e315f1197db93b";
    @GetMapping("/api")
    public BoxOfficeResultVO callApiWithJson() {
        StringBuilder result = new StringBuilder();
        BoxOfficeResultVO boxOfficeResultVO = null;

        try {
            String apiUrl = "http://kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchWeeklyBoxOfficeList.json?" +
                            "key="+key+ "&targetDt=20230701&weekGb=0";

            URL url = new URL(apiUrl);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.connect();

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream(), StandardCharsets.UTF_8));
            String returnLine;

            JSONParser jsonParser = new JSONParser();
            ObjectMapper mapper = new ObjectMapper();
            while((returnLine = bufferedReader.readLine()) != null) {
                result.append(returnLine);

                JSONObject jsonObject = (JSONObject)jsonParser.parse(result.toString());
                JSONObject boxoffice = (JSONObject)jsonObject.get("boxOfficeResult");
                boxOfficeResultVO = mapper.readValue(boxoffice.toString(), BoxOfficeResultVO.class);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        if (boxOfficeResultVO != null) {
//            System.out.println(boxOfficeResultVO.getWeeklyBoxOfficeList());

        }

        // String id, Genre genre, String name, Date openingDate, int runningTime
        List<Movie> movieList= new ArrayList<>();
        for (BoxOfficeVO movies: boxOfficeResultVO.getWeeklyBoxOfficeList()) {

//            SearchMovieInfoVO movieInfo = callMovieDetail(movies.getMovieCd());

            SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
            Date date = null;

            try {
                date = sf.parse(movies.getOpenDt());
            } catch (ParseException e) {
                e.printStackTrace();
            }
//Genre.valueOf(movieInfo.getGenreNm())
//            Movie movie = new Movie(movies.getMovieCd(), StringToGenre(movieInfo.getGenreNm()) , movies.getMovieNm(),
//                    date, Integer.parseInt(movieInfo.getShowTm()));
//            movies.getMovieCd();

//            movieList = Arrays.asList(movie);

            System.out.println(callMovieDetail(movies.getMovieCd()).getGenreNm());
        }

//        System.out.println("movieList = " + movieList);

//        callMovieDetail("20226411");

        return boxOfficeResultVO;
    }

/*
* 20228930
20232273
20226411
20232180
20211937
20219331
20232220
20231971
20232075
20231781
* */
    public SearchMovieInfoVO callMovieDetail(String movieCd) {
        StringBuilder result = new StringBuilder();
        SearchMovieInfoVO searchMovieInfoVO = new SearchMovieInfoVO();

        try {
            String apiUrl = "http://www.kobis.or.kr/kobisopenapi/webservice/rest/movie/searchMovieInfo.json?"
                        + "key="+ key +"&movieCd="+movieCd;

            URL url = new URL(apiUrl);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.connect();

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream(), StandardCharsets.UTF_8));
            String returnLine;

            JSONParser jsonParser = new JSONParser();
            ObjectMapper mapper = new ObjectMapper();
            while((returnLine = bufferedReader.readLine()) != null) {
                result.append(returnLine);

                JSONObject jsonObject = (JSONObject)jsonParser.parse(result.toString());
                JSONObject movieInfoResult = (JSONObject)jsonObject.get("movieInfoResult");
                JSONObject movieInfo = (JSONObject) movieInfoResult.get("movieInfo");
                searchMovieInfoVO = mapper.readValue(movieInfo.toString(), SearchMovieInfoVO.class);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (searchMovieInfoVO != null) {
//            System.out.println(searchMovieInfoVO);
        }

        return searchMovieInfoVO;
    }

    // 데이터 저장할것만 추려서 조인해서 insert


    public Genre StringToGenre(String genreName) {
        switch (genreName) {
            case "어드벤처":
                return Genre.ADVENTURE;
            case "액션":
                return Genre.ACTION;
            case "호러":
                return Genre.HORROR;
            case "코메디":
                return Genre.COMEDY;
            case "서스펜스":
                return Genre.SUSPENCE;
            case "크라임":
                return Genre.CRIME;
            case "픽션":
                return Genre.FICTION;
            case "애니메이션":
                return Genre.ANIMATED;
            case "":
                return Genre.NONE;

        }
        return Genre.NONE;
    }
}
