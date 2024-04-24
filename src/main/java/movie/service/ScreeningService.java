package movie.service;

import movie.domain.*;
import movie.repository.MovieRepository;
import movie.repository.ScreeningRepository;
import movie.repository.TheaterRepository;
import movie.repository.TicketRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalTime;

@Service
@Transactional(readOnly = true)
public class ScreeningService {

    private final TicketRepository ticketRepository;
    private final ScreeningRepository screeningRepository;
    private final MovieRepository movieRepository;
    private final TheaterRepository theaterRepository;

    public ScreeningService(TicketRepository ticketRepository, ScreeningRepository screeningRepository, MovieRepository movieRepository, TheaterRepository theaterRepository) {
        this.ticketRepository = ticketRepository;
        this.screeningRepository = screeningRepository;
        this.movieRepository = movieRepository;
        this.theaterRepository = theaterRepository;
    }

    @Transactional
    public void createScreen(LocalTime startTime, String movieId, Long theaterId) {
        Movie movie = movieRepository.findOne(movieId);
        Theater theater = theaterRepository.findOne(theaterId);
        LocalTime endTime = startTime.plusMinutes(movie.getRunningTime());
        Screen screen = new Screen(startTime, endTime, movie, theater);
        screeningRepository.save(screen);
    }

    public void findScreeningInformation(Long screenId) {
        Screen screen = screeningRepository.findOne(screenId);
        Theater theater = theaterRepository.findOne(screen.getTheater().getId());

    }

}
