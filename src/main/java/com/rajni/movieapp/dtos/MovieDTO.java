package com.rajni.movieapp.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Data
@Setter
@Getter
@NoArgsConstructor
public class MovieDTO {
    private int movieId;
    private String movieName;
    private String movieDescription;
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss[.SSS][.SS][.S]")
    private LocalDateTime releaseDate;
    private int duration;
    private String coverPhotoUrl;
    private String trailerUrl;
}
