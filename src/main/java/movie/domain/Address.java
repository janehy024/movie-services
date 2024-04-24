package movie.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

@AllArgsConstructor
@NoArgsConstructor

@Embeddable
@Getter
public class Address {

    private String city;
    private String street;
    private String zipCode;
}
