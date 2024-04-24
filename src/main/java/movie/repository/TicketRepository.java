package movie.repository;

import movie.domain.ScreenSeat;
import movie.domain.Ticket;
import movie.dto.TicketDTO;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class TicketRepository {

    @PersistenceContext
    private final EntityManager em;

    public TicketRepository(EntityManager em) {
        this.em = em;
    }

    public Long save(Ticket ticket) {
        em.persist(ticket);
        return ticket.getId();
    }

    public Ticket findOne(Long ticketId) {
        return em.find(Ticket.class, ticketId);
    }

    public void remove(ScreenSeat screenSeat) {
        em.remove(screenSeat);
    }

    public List<Ticket> findTicketsByTicketId(Long ticketId) {
        TypedQuery<Ticket> query =
                em.createQuery("select distinct t from Ticket t join fetch t.screenSeats where t.id=:ticketId", Ticket.class);
        query.setParameter("ticketId",ticketId);
        List<Ticket> result = query.getResultList();
        return result;
    }

}
