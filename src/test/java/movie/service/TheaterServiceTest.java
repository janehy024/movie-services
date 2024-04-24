package movie.service;

import junit.framework.TestCase;
import movie.domain.Seat;
import movie.domain.Theater;
import movie.repository.TheaterRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;


@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class TheaterServiceTest extends TestCase {

    @Autowired
    TheaterService theaterService;

    @Autowired
    TheaterRepository theaterRepository;

    @Test
    @Rollback(value = false)
    public void testInsertTheater() throws Exception {
//        Theater theater = new Theater("3관", 6);

        Long theaterId = theaterService.createTheater("5관", 7, 3, 2);

//        for (int i=1; i<=3; i++) {
//            for (int j=1; j<=2; j++)
//                theater.addSeat(new Seat(i,j, theater));
//        }
//        theaterRepository.save(theater);
        theaterService.showTheaterSeats(theaterId);
    }



}