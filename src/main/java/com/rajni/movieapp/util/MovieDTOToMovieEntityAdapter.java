package com.rajni.movieapp.util;

import com.rajni.movieapp.dtos.MovieDTO;
import com.rajni.movieapp.entities.Movie;
import org.springframework.stereotype.Component;

@Component
public class MovieDTOToMovieEntityAdapter implements Adapter<MovieDTO, Movie> {
    @Override
    public Movie convertFrom(MovieDTO movieDTO) {
        Movie movie = new Movie();
        movie.setMovieId(movieDTO.getMovieId());
        movie.setMovieName(movieDTO.getMovieName());
        movie.setMovieDescription(movieDTO.getMovieDescription());
        movie.setDuration(movieDTO.getDuration());
        movie.setReleaseDate(movieDTO.getReleaseDate());
        movie.setTrailerUrl(movieDTO.getTrailerUrl());
        movie.setCoverPhotoUrl(movieDTO.getCoverPhotoUrl());
        return movie;
    }
}
