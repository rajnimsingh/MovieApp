package com.rajni.movieapp.util;

import com.rajni.movieapp.entities.Movie;
import org.springframework.stereotype.Component;

@Component
public class MovieSelfAdapter implements Adapter<Movie, Movie> {
    @Override
    public Movie convertFrom(Movie movie) {
        Movie target = new Movie();
        target.setMovieDescription(movie.getMovieDescription());
        target.setMovieName(movie.getMovieName());
        target.setDuration(movie.getDuration());
        target.setCoverPhotoUrl(movie.getCoverPhotoUrl());
        target.setTrailerUrl(movie.getTrailerUrl());
        target.setReleaseDate(movie.getReleaseDate());
        return target;
    }
}


