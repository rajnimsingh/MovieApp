package com.rajni.movieapp.entities;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import static com.rajni.movieapp.util.MovieDBConstants.*;

@Entity
@Table(name = MOVIE_DB)
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = MOVIE_ID_COL)
    private int movieId;

    @Column(name = MOVIE_NAME_COL, length = 500, nullable = false, unique = true)
    private String movieName;

    @Column(name = MOVIE_DESCRIPTION_COL, length = 500, nullable = false)
    private String movieDescription;

    @Column(name = MOVIE_RELEASE_DATE_COL, nullable = false)
    private LocalDateTime releaseDate;

    @Column(name = MOVIE_DURATION_COL, nullable = false)
    private int duration;

    @Column(name = MOVIE_COVER_PHOTO_URL_COL, nullable = false)
    private String coverPhotoUrl;

    @Column(name = MOVIE_TRAILER_URL_COL, nullable = false)
    private String trailerUrl;
}
