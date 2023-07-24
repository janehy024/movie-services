package movie.movieservice.service;


import lombok.RequiredArgsConstructor;
import movie.movieservice.domain.Genre;
import movie.movieservice.domain.Movie;
import movie.movieservice.domain.User;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
@RequiredArgsConstructor
public class InitDb {

    private final InitService initService;

    @PostConstruct
    public void init() {
        initService.dbInit1();
    }

    @Component
    @Transactional
    @RequiredArgsConstructor
    static class InitService{

        static SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        private final EntityManager em;

        public void dbInit1(){

            //영화 추가
            Movie movie1 = new Movie();
            Movie movie2 = new Movie();
            Date openingDate = null;
            try {
                openingDate = format.parse("2022-12-22");
            } catch (ParseException e) {
                e.printStackTrace();
            }
            movie1.createMovie("aa",openingDate, 100, Genre.HORROR);
            movie2.createMovie("bb",openingDate,130, Genre.ACTION);
            em.persist(movie1);
            em.persist(movie2);

            //배우 추가

            //감독 추가

            //user 추가
            User user1 = new User();
            user1.createUser("차재원", 24, "대구광역시" , "로" , "12345");
            em.persist(user1);

            //극장 추가

            //좌석 추가

            //상영 추가

            //티켓

        }
    }
    //ㅎㅇ
    //ㅂㅇ
}
