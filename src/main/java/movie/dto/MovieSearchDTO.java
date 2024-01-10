package movie.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import movie.domain.Worker;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MovieSearchDTO {
    private Worker director;
    private Worker actor;
    private Date openingDate;
}
