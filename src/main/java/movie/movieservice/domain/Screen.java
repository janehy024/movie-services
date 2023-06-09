package movie.movieservice.domain;

import lombok.Getter;

import java.time.LocalTime;

@Getter
public class Screen {
    private Long id;

    private Movie movie;//영화 이름

    private Theater theater; //상영관 이름

    private LocalTime startTime;
    private LocalTime endTime;

    //연관 메서드
    public void setMovie(Movie movie){
        if(this.movie != null){
            this.movie.getScreens().remove(this);
        }
        this.movie = movie;
        movie.getScreens().add(this);
    }

    public void setTheater(Theater theater){
        if(this.theater != null){
            this.theater.getScreens().remove(this);
        }
        this.theater = theater;
        theater.getScreens().add(this);
    }

    //생성 메서드
    public Screen(LocalTime startTime, LocalTime endTime, Movie movie, Theater theater){

        this.movie = movie;
        this.theater = theater;
        this.startTime = startTime;
        this.endTime = endTime;

        movie.getScreens().add(this);
        theater.getScreens().add(this);
    }


}
