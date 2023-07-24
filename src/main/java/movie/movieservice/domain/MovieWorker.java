package movie.movieservice.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor

@Setter //set 사용?
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

    //생성 메서드
    public MovieWorker(Movie movie){
        this.movie = movie;
    }
}
