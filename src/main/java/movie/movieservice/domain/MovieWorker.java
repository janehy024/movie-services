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
    private Worker workers;

    //연관 메서드
    public void setMovie(Movie movie){
        if(this.movie != null){
            this.movie.getMovieWorkers().remove(this);
        }
        this.movie = movie;
        movie.getMovieWorkers().add(this);
    }

    public void setWorkers(Worker worker){
        if(this.workers != null){
            this.workers.getMovieWorkers().remove(this);
        }
        this.workers = worker;
        worker.getMovieWorkers().add(this);
    }

    //생성 메서드
    public MovieWorker(Movie movie){
        this.movie = movie;
    }
}
