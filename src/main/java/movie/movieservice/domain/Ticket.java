package movie.movieservice.domain;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Ticket {

    private Long id;

    private User user;

    private Screen screen;

    private List<ScreenSeat> screenSeats = new ArrayList<ScreenSeat>();

    private Boolean state;

    //연관관계 메서드
    public void setUser(User user){
        if(this.user != null){
            this.user.getTickets().remove(this);
        }
        this.user = user;
        user.getTickets().add(this);
    }

    public void addScreenSeat(ScreenSeat screenSeat){
        this.screenSeats.add(screenSeat);
        if(screenSeat.getTicket() != this)
            screenSeat.setTicket(this);
    }

    //생성메서드
    public Ticket(User user, Screen screen){
        this.user = user;
        this.screen = screen;
        this.state = true;

        user.getTickets().add(this);
    }
}
