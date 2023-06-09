package movie.movieservice.domain;

import lombok.Getter;

@Getter
public class ScreenSeat {

    private Long id;

    private Seat seat;

    private Ticket ticket;

    //연관관계 메서드
    public void setTicket(Ticket ticket){
        if(this.ticket != null){
            this.ticket.getScreenSeats().remove(this);
        }
        this.ticket = ticket;
        ticket.getScreenSeats().add(this);
    }

    public void setSeat(Seat seat){
        if(this.seat != null){
            this.seat.getScreenSeats().remove(this);
        }
        this.seat = seat;
        seat.getScreenSeats().add(this);
    }

    //생성 메서드
    public ScreenSeat(Ticket ticket, Seat seat){
        this.ticket = ticket;
        this.seat = seat;

        ticket.getScreenSeats().add(this);
        seat.getScreenSeats().add(this);
    }
}
