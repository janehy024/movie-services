package movie.movieservice.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Getter
@Entity

@NoArgsConstructor
public class Director extends Worker{

    @Id
    @GeneratedValue
    @Column(name = "WORKER_ID")
    private Long id;

    private String birthPlace;

    //생성 매서드
    public void Director(String name, Date birthday, String birthPlace){
        this.setName(name);
        this.setBirth(birthday);
        this.birthPlace = birthPlace;
    }
}
