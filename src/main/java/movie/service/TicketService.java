package movie.service;

import movie.domain.*;
import movie.repository.ScreeningRepository;
import movie.repository.TheaterRepository;
import movie.repository.TicketRepository;
import movie.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
public class TicketService {
    private final TicketRepository ticketRepository;
    private final UserRepository userRepository;
    private final ScreeningRepository screeningRepository;
    private final TheaterRepository theaterRepository;

    public TicketService(TicketRepository ticketRepository, UserRepository userRepository, ScreeningRepository screeningRepository, TheaterRepository theaterRepository) {
        this.ticketRepository = ticketRepository;
        this.userRepository = userRepository;
        this.screeningRepository = screeningRepository;
        this.theaterRepository = theaterRepository;
    }

    public void createTicket(Long userId, Long screenId, Long[] seatsId) {
        User user = userRepository.findOne(userId);
        Screen screen = screeningRepository.findOne(screenId);

        Long ticketId = ticketRepository.save(new Ticket(user, screen));
        Ticket ticket = ticketRepository.findOne(ticketId);


        ScreenSeat[] screenSeats = new ScreenSeat[seatsId.length];
        Arrays.stream(screenSeats).forEach(screenSeat -> {
            for (Long seatId : seatsId) {
                Seat seat = theaterRepository.findSeatBySeatId(seatId);
                theaterRepository.saveScreenSeat(ticket, seat);
            }
        });
    }

    public void cancelTicketing(Long ticketId) {
        Ticket ticket = ticketRepository.findOne(ticketId);
        List<Ticket> tickets = ticketRepository.findTicketsByTicketId(ticketId);

        tickets.stream().peek(tck-> {
            tck.changeState();
            tck.getScreenSeats().stream().forEach(t-> {
                ticketRepository.remove(t);
            });
        });
    }

    public void ticketInfo(Long ticketId) {
        Ticket ticket = ticketRepository.findOne(ticketId);

        if (ticket == null) {
            System.out.println("예매 정보가 없습니다.");
            return;
        }

        Movie movie = ticket.getScreen().getMovie();
        Theater theater = ticket.getScreen().getTheater();
        List<ScreenSeat> screenSeat = ticket.getScreenSeats();
        Screen screen = ticket.getScreen();


        System.out.println(movie.getName() + " " + theater.getName() + " " + screenSeat + " " + screen.getStartTime());

    }
}
