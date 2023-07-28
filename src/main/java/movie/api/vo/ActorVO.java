package movie.api.vo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ActorVO {
    private String peopleNm;
    private String peopleNmEn;
    private String cast;
    private String castEn;
    // getters and setters
}
