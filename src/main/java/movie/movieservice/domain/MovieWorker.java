package movie.movieservice.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor

@Getter
@Entity
public class MovieWorker {

    @Id
    @GeneratedValue
    @Column(name= "MOVIE_WORKER_ID")
    private Long id;

    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name="MOVIE_ID")
    private Movie movie;

    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name="WORKER_ID")
    private Worker worker;

    @Enumerated(EnumType.STRING)
    private RoleType roleType;

    //연관 메서드
    public void setMovie(Movie movie){
        if(this.movie != null){
            this.movie.getMovieWorkers().remove(this);
        }
        this.movie = movie;
        movie.getMovieWorkers().add(this);
    }

    public void setWorker(Worker worker){
        if(this.worker != null){
            this.worker.getMovieWorkers().remove(this);
        }
        this.worker = worker;
        worker.getMovieWorkers().add(this);
    }

    //생성 메서드
    public MovieWorker(RoleType roleType, Movie movie){
        this.roleType = roleType;
        this.movie = movie;
    }
}
