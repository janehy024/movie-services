package movie.api.vo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class SearchMovieInfoVO {
        private String movieCd;
        private String movieNm;
        private String movieNmEn;
        private String movieNmOg;
        private String prdtYear;
        private String showTm;
        private String openDt;
        private String prdtStatNm;
        private String typeNm;
        private List<NationVO> nations;
        private List<Genrevo> genres;
        private List<DirectorVO> directors;
        private List<ActorVO> actors;
        private List<ShowTypeVO> showTypes;
        private List<AuditVO> audits;
        private List<CompanyVO> companys;
        private List<StaffVO> staffs;


}

/*@Data
@JsonIgnoreProperties(ignoreUnknown = true)
class GenreVO {
        private String genreNm;

        public String getGenreNm() {
                return genreNm;
        }
}*/



@Data
@JsonIgnoreProperties(ignoreUnknown = true)
class NationVO {
        private String nationNm;
        // getters and setters
}


@Data
@JsonIgnoreProperties(ignoreUnknown = true)
class ShowTypeVO {
        private String showTypeGroupNm;
        private String showTypeNm;
        // getters and setters
}


@Data
@JsonIgnoreProperties(ignoreUnknown = true)
class AuditVO {
        private String auditNo;
        private String watchGradeNm;
        // getters and setters
}


@Data
@JsonIgnoreProperties(ignoreUnknown = true)
class CompanyVO {
        private String companyCd;
        private String companyNm;
        private String companyNmEn;
        private String companyPartNm;
        // getters and setters
}


@Data
@JsonIgnoreProperties(ignoreUnknown = true)
class StaffVO {
        private String peopleNm;
        private String peopleNmEn;
        private String staffRoleNm;
        // getters and setters
}

