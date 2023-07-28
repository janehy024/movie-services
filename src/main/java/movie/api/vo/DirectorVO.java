package movie.api.vo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class DirectorVO {
    private String peopleNm;
    private String peopleNmEn;
    // getters and setters
}
