package movie.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor

@Entity
@Getter
public class Ticket {

    @Id
    @GeneratedValue
    @Column(name = "TICKET_ID")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name ="USER_ID")
    private User user;

    @OneToOne(fetch= FetchType.LAZY)    // 주 테이블에 외래키 설정
    @JoinColumn(name = "SCREEN_ID")
    private Screen screen;

    @OneToMany(fetch= FetchType.LAZY)
    @JoinColumn(name = "TICKET_ID")
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

    public void changeState() {
        this.state = false;
    }
}
