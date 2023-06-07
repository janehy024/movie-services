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
        this.movie = movie;
    }


}
