package movie.service;


import lombok.RequiredArgsConstructor;
import movie.domain.Movie;
import movie.domain.User;
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

        }
    }
}
