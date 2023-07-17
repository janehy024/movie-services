package vo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class BoxOfficeResultVO {
        private String boxofficeType;
        private String showRange;
        private String yearWeekTime;
        private List<BoxOfficeVO> weeklyBoxOfficeList;
}
