package movie.movieservice.domain;

import lombok.Getter;
import lombok.Setter;

@Setter //set 사용?
@Getter
public class MovieWorker {

    private Long id;

    private Movie movie;

    private Worker worker;

    private RoleType roleType;

    //생성 메서드
    public MovieWorker(RoleType roleType, Movie movie){
        this.roleType = roleType;
        this.movie = movie;
    }
}
