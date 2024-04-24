package movie.domain;


import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor //생성메서드를 사용하지 않고 직접생성 하는것을 금지 하는 것
@DiscriminatorValue("ACTORS")
public class Actor extends Worker {

    @Id @GeneratedValue
    @Column(name = "WORKER_ID")
    private Long id;

    private Integer height;
    private String instagram;

    //연관관계 메서드

    //생성 메서드
//    public void Actor(String name, Date birthday, Integer height, String instagram){
//        this.setName(name);
//        this.setBirth(birthday);
//        this.height = height;
//        this.instagram = instagram;
//    }

    public Actor(String name) {
        this.setName(name);
    }

}
