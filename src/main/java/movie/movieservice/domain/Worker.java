package movie.movieservice.domain;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@NoArgsConstructor

@Getter @Setter
@Inheritance(strategy =  InheritanceType.JOINED)
@DiscriminatorColumn(name = "dtype")

@Entity
public abstract class Worker {

    @Id @GeneratedValue
    @Column(name = "WORKER_ID")
    private Long id;

    private String name;

    @Temporal(TemporalType.DATE)
    private Date birth;

    private String filo;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "WORKER_ID")
    private List<MovieWorker> movieWorkers = new ArrayList<MovieWorker>();

    //생성 메서드
    public void addMovieWorker(MovieWorker movieWorker) {
        this.movieWorkers.add(movieWorker);
        if (movieWorker.getWorkers() != this) {
            movieWorker.setWorkers(this);
        }
    }
}
