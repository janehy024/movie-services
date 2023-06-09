package movie.movieservice.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalTime;

@NoArgsConstructor

@Entity
@Getter
public class Screen {

    @Id @GeneratedValue
    @Column(name="SCREEN_ID")
    private Long id;

    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name = "MOVIE_ID")
    private Movie movie;//영화 이름

    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name = "THEATER_ID")
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
