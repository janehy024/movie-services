package movie.repository;


import movie.domain.ScreenSeat;
import movie.domain.Seat;
import movie.domain.Theater;
import movie.domain.Ticket;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class TheaterRepository {
    @PersistenceContext
    private final EntityManager em;

    public TheaterRepository(EntityManager em) {
        this.em = em;
    }

    public Long save(Theater theater){
        em.persist(theater);
        return theater.getId();
    }

    public Theater findOne(Long theaterId) {
        return em.find(Theater.class, theaterId);
    }


    public void saveSeats(Seat seat) {
        em.persist(seat);
    }

    public void saveScreenSeat(Ticket ticket, Seat seat) {
        em.persist(new ScreenSeat(ticket, seat));
    }

    public Seat findSeatBySeatId(Long seatId) {
        return em.find(Seat.class, seatId);
    }
}
