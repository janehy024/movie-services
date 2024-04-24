package movie.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MovieApiController {

    @Autowired
    private final MovieApiService movieService;

    @Autowired
    public MovieApiController(MovieApiService movieService) {
        this.movieService = movieService;
    }
}
