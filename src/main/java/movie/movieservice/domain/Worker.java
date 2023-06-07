package movie.movieservice.domain;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter @Setter
@Inheritance(strategy =  InheritanceType.JOINED)
@DiscriminatorColumn(name = "dtype")

@Entity
public abstract class Worker {

    @Id @GeneratedValue
    @Column(name = "WORKER_ID")
    private Long id;

    private String name;

    private Date birth;

    private String filo;

    //생성 메서드



}
