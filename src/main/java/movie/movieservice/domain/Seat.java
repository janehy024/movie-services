package movie.movieservice.domain;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Seat {

    private Long id;

    private Integer seatRow;
    private Integer seatColum;

    private Boolean state;

    private Theater theater;

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
