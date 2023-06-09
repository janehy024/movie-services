package movie.movieservice.domain;

import lombok.Getter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
public class Movie {

    private Long id;

    private String name;

    private Date openingDate;

    private Integer runningTime;

    private Genre genre;

    //출연진
    private List<MovieWorker> movieWorkers = new ArrayList<>();

    //상영시간표
    private List<Screen> screens = new ArrayList<>();

    //연관 메서드
    public void addMovieWorker(MovieWorker movieWorker) {
        this.movieWorkers.add(movieWorker);
        if (movieWorker.getMovie() != this) {
            movieWorker.setMovie(this);
        }
    }

    public void addScreen(Screen screen) {
        this.screens.add(screen);
        if(screen.getMovie() != this){
            screen.setMovie(this);
        }

    }




}
