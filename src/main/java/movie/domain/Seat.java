package movie.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor

@Entity
@Getter
public class Seat {

    @Id
    @GeneratedValue
    @Column(name= "SEAT_ID")
    private Long id;

    private Integer seatRow;
    private Integer seatColum;
    private Boolean state;

    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name= "THEATER_ID")
    private Theater theater;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "SEAT_ID")
    private List<ScreenSeat> screenSeats = new ArrayList<ScreenSeat>();


    //연관 관계 메서드
    public void addScreenSeat(ScreenSeat screenSeat){
        this.screenSeats.add(screenSeat);
        if(screenSeat.getSeat() != this)
            screenSeat.setSeat(this);
    }

    public void setTheater(Theater theater){
        if(this.theater != null){
            this.theater.getSeats().remove(this);
        }
        this.theater = theater;
        theater.getSeats().add(this);
    }


    //생성 메서드
    public Seat(Integer seatRow, Integer seatColumn, Theater theater){
        this.seatRow = seatRow;
        this.seatColum = seatColumn;
        this.state = true;
        this.theater = theater;

        theater.getSeats().add(this);
    }
}
