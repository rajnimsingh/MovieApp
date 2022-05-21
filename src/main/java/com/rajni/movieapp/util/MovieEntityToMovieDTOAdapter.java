package com.rajni.movieapp.util;

import com.rajni.movieapp.dtos.MovieDTO;
import com.rajni.movieapp.entities.Movie;
import org.springframework.stereotype.Component;

@Component
public class MovieEntityToMovieDTOAdapter implements Adapter<Movie, MovieDTO> {

    @Override
    public MovieDTO convertFrom(Movie movie) {
        MovieDTO movieDTO = new MovieDTO();
        if (movie != null) {
            movieDTO.setMovieId(movie.getMovieId());
            movieDTO.setMovieName(movie.getMovieName());
            movieDTO.setMovieDescription(movie.getMovieDescription());
            movieDTO.setDuration(movie.getDuration());
            movieDTO.setReleaseDate(movie.getReleaseDate());
            movieDTO.setCoverPhotoUrl(movie.getCoverPhotoUrl());
            movieDTO.setTrailerUrl(movie.getTrailerUrl());
        }

        return movieDTO;
    }
}
