package movie.api.vo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class BoxOfficeResultVO {
        private String boxofficeType;
        private String showRange;
        private String yearWeekTime;
        private List<BoxOfficeVO> weeklyBoxOfficeList;
}
