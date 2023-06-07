package movie.movieservice.domain;

public class MovieWorker {

    private Long id;

    private Movie movie;

    private Worker worker;

    private RoleType roleType;

    //생성 메서드
    public void addMovieWorker(RoleType roleType, Movie movie){
        this.roleType = roleType;
        this.movie = movie;
    }
}
