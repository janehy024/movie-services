package movie.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor

@Entity
@Getter
public class Theater {

    @Id
    @GeneratedValue
    @Column(name = "THEATER_ID")
    private Long id;

    private String name;
    private Integer floor;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name="THEATER_ID")
    private List<Screen> screens = new ArrayList<Screen>();



    @OneToMany(fetch= FetchType.LAZY)
    @JoinColumn(name = "THEATER_ID")
    private List<Seat> seats = new ArrayList<Seat>();

    //연관관계 메서드
    public void addScreen(Screen screen){
        this.screens.add(screen);
        if(screen.getTheater() != this)
            screen.setTheater(this);
    }

    public void addSeat(Seat seat) {
        this.seats.add(seat);
        if (seat.getTheater() != this) {
            seat.setTheater(this);
        }
    }

    //생성 메서드
    public Theater(String name, Integer floor){
        this.name = name;
        this.floor = floor;
    }
}
