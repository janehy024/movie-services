package movie.movieservice.domain;

import java.util.Date;

public class Director extends Worker{

    private Long id;

    private String birthPlace;

    //생성 매서드
    public void Director(String name, Date birthday, String birthPlace){
        this.setName(name);
        this.setBirth(birthday);
        this.birthPlace = birthPlace;
    }
}
