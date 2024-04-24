package movie.service;

import movie.domain.Screen;
import movie.domain.ScreenSeat;
import movie.domain.Seat;
import movie.domain.Theater;
import movie.repository.MovieRepository;
import movie.repository.ScreeningRepository;
import movie.repository.TheaterRepository;
import movie.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class TheaterService {


    private final TicketRepository ticketRepository;
    private final ScreeningRepository screeningRepository;
    private final MovieRepository movieRepository;
    private final TheaterRepository theaterRepository;

    @Autowired
    public TheaterService(TicketRepository ticketRepository, ScreeningRepository screeningRepository, MovieRepository movieRepository, TheaterRepository theaterRepository) {
        this.ticketRepository = ticketRepository;
        this.screeningRepository = screeningRepository;
        this.movieRepository = movieRepository;
        this.theaterRepository = theaterRepository;
    }

//    @Transactional
    public Long createTheater(String theaterName, int floor, int row, int col) {
        Theater theater = new Theater(theaterName, floor);
        Long theaterId = theaterRepository.save(theater);

        for (int i=1; i<=row; i++) {
            for (int j=1; j<=col; j++)
                theaterRepository.saveSeats(new Seat(i,j, theater));
        }

        return theaterId;
    }

    public void showTheaterSeats(Long theaterId) {
        Theater theater = theaterRepository.findOne(theaterId);
        Screen screen = screeningRepository.findByTheaterId(theaterId);

        showAvailableOneScreenTheaterSeats(screen, theater);
    }

    private void showAvailableOneScreenTheaterSeats(Screen screen, Theater theater) {
        System.out.println("영화 이름 → " + screen.getMovie().getName());
        System.out.println("시작 시간 → " + screen.getStartTime());
        System.out.println("종료 시간 → " + screen.getEndTime());

        System.out.println("총 좌석 및 예매 가능 좌석 ↓");
        System.out.println("           Screen");
        System.out.printf("     1    2    3    4    5");

        theater.getSeats().forEach(seat -> {
            if (seat.getState())
                System.out.print("    □");
            else
                System.out.printf("   ■");
        });

        System.out.println();
        System.out.println("■ : 예약 불가능, □ : 예약 가능 ");
    }



}
