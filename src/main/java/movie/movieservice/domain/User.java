package movie.movieservice.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor

@Entity
@Getter
public class User extends BaseEntity{

    @Id
    @GeneratedValue
    @Column(name = "USER_ID")
    private Long id;

    private String name;
    private Integer age;

    @Embedded
    private Address address;

    @OneToMany(fetch= FetchType.LAZY, cascade = CascadeType.REMOVE, mappedBy = "user")
    private List<Ticket> tickets = new ArrayList<Ticket>();


    //연관메서드
    public void addTicket(Ticket ticket) {
        this.tickets.add(ticket);
        if (ticket.getUser() != this) {
            ticket.setUser(this);
        }
    }

    //생성 메서드
    public void createUser(String name, Integer age, String city, String street, String zipCode){

        this.name = name;
        this.age = age;
        Address address = new Address(city, street, zipCode);
        this.address = address;
        this.setCreateTime(LocalDateTime.now());
    }

    //수정 로직
    public void editUser(String findName, String editName){

    }
}
