package movie.movieservice.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@NoArgsConstructor

@Getter
@Entity
public class Movie {

    @Id
    @GeneratedValue
    @Column(name = "MOVIE_ID")
    private Long id;

    private String name;

    @Temporal(TemporalType.DATE)
    private Date openingDate;
    private Integer runningTime;

    @Enumerated(EnumType.STRING)
    private Genre genre;

    //출연진
    @OneToMany(fetch= FetchType.LAZY)
    @JoinColumn(name = "MOVIE_ID")
    private List<MovieWorker> movieWorkers = new ArrayList<>();

    //상영시간표
    @OneToMany(fetch= FetchType.LAZY)
    @JoinColumn(name = "MOVIE_ID")
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
