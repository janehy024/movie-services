package movie.movieservice.domain;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Getter
@NoArgsConstructor //생성메서드를 사용하지 않고 직접생성 하는것을 금지 하는 것
public class Actor extends Worker {

/*    @Id @GeneratedValue
    @Column(name = "WORKER_ID")
    private Long id;*/

    private Integer height;
    private String instagram;

    //연관관계 메서드

    //생성 메서드
    public void Actor(String name, Date birthday, Integer height, String instagram){
        this.setName(name);
        this.setBirth(birthday);
        this.height = height;
        this.instagram = instagram;
    }

}
