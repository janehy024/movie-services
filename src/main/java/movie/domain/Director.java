package movie.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Entity
@DiscriminatorValue("DIRECTORS")
@NoArgsConstructor
public class Director extends Worker{

    @Id
    @GeneratedValue
    @Column(name = "WORKER_ID")
    private Long id;

    private String birthPlace;

    //생성 매서드
/*    public void Director(String name, Date birthday, String birthPlace){
        this.setName(name);
        this.setBirth(birthday);
        this.birthPlace = birthPlace;
    }*/

    public Director(String name) {
        this.setName(name);
    }


}
