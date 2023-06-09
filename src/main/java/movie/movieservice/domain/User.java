package movie.movieservice.domain;

import lombok.Getter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
public class User extends BaseEntity{

    private Long id;
    private String name;
    private Integer age;

    private Address address;

    private List<Ticket> tickets = new ArrayList<Ticket>();


    //연관메서드
    public void addTicket(Ticket ticket) {
        this.tickets.add(ticket);
        if (ticket.getUser() != this) {
            ticket.setUser(this);
        }
    }

    //생성 메서드
    public User(String name, Integer age, String city, String street, String zipCode){
        this.name = name;
        this.age = age;
        Address address = new Address(city, street, zipCode);
        this.address = address;
        this.setCreateTime(LocalDateTime.now());
    }
}
