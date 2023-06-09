package movie.movieservice.domain;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Theater {

    private Long id;

    private String name;
    private Integer floor;

    private List<Screen> screens = new ArrayList<Screen>();

    public void addScreen(Screen screen){
        this.screens.add(screen);
        if(screen.getTheater() != this)
            screen.setTheater(this);
    }

    private List<Seat> seats = new ArrayList<Seat>();

    public void addSeat(Seat seat) {
        this.seats.add(seat);
        if (seat.getTheater() != this) {
            seat.setTheater(this);
        }
    }

    public Theater(String name, Integer floor){
        this.name = name;
        this.floor = floor;
    }
}
