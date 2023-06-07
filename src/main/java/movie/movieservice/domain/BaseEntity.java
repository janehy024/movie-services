package movie.movieservice.domain;

import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@MappedSuperclass
public class BaseEntity {

    private LocalDateTime createTime;
    private LocalDateTime EditTime;
}
