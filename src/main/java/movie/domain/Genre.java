package movie.domain;

public enum Genre {
    ADVENTURE("어드벤처"),
    ACTION("액션"),
    HORROR("호러"),
    COMEDY("코미디"),
    SUSPENCE("서스펜스"),
    CRIME("범죄"),
    FICTION("픽션"),
    ANIMATED("애니메이션"),
    DRAMA("드라마"),
    PERFORMANCE("공연"),

    NONE("");

    private String genreName;

    Genre(String genreName) {
        this.genreName = genreName;
    }

    public static Genre fromString(String genreName) {
        for (Genre genre : Genre.values()) {
            if (genre.genreName.equals(genreName)) {
                return genre;
            }
        }
        return NONE;
    }
}
