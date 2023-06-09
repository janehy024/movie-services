package movie.movieservice.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Setter
@Getter
@MappedSuperclass
public class BaseEntity {

    private LocalDateTime createTime;
    private LocalDateTime EditTime;
}
