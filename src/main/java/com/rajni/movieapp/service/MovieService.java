package com.rajni.movieapp.service;

import com.rajni.movieapp.entities.Movie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface MovieService {
    Movie acceptMovieDetails(Movie movie);

    void acceptMultipleMovieDetails(List<Movie> movies);

    Movie getMovieDetails(int movieId);

    Movie updateMovieDetails(int movieId, Movie movie);

    boolean deleteMovie(int movieId);

    List<Movie> getAllMovies();

    Page<Movie> getPaginatedMovieDetails(Pageable pageable);
}
