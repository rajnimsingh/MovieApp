package com.rajni.movieapp.service;

import com.rajni.movieapp.dao.MovieDao;
import com.rajni.movieapp.entities.Movie;
import com.rajni.movieapp.util.MovieSelfAdapter;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Log4j2
public class MovieServiceImpl implements MovieService {

    private final MovieDao movieDao;

    private final MovieSelfAdapter selfMovieAdapter;

    @Autowired
    public MovieServiceImpl(MovieDao movieDao, MovieSelfAdapter selfMovieAdapter) {
        this.movieDao = movieDao;
        this.selfMovieAdapter = selfMovieAdapter;
    }


    @Override
    public Movie acceptMovieDetails(Movie movie) {
        final Movie savedMovie = movieDao.save(movie);
        log.info("Movie has been saved with Id , {}", savedMovie.getMovieId());
        return savedMovie;
    }

    @Override
    public void acceptMultipleMovieDetails(List<Movie> movies) {
        movies.forEach(this::acceptMovieDetails);
    }

    @Override
    public Movie getMovieDetails(int movieId) {
        final Optional<Movie> optionalMovie = movieDao.findById(movieId);
        Movie result = null;
        if (optionalMovie.isPresent()) {
            result = optionalMovie.get();
        }
        log.info("Found movie Details for Id : {}, are {}", movieId, result);
        return result;
    }

    @Override
    // Add AOP here to check non-null movie.
    public Movie updateMovieDetails(int movieId, Movie movie) {

        final Optional<Movie> existingMovie = movieDao.findById(movieId);

        if (existingMovie.isPresent()) {
            // Now update the existing movie details.
            if (movie != null) {
                final Movie updatedMovie = selfMovieAdapter.convertFrom(movie);
                updatedMovie.setMovieId(movieId);
                acceptMovieDetails(updatedMovie);
                return updatedMovie;
            }
        }
        return null;
    }

    @Override
    public boolean deleteMovie(int movieId) {
        final Movie existingMovie = getMovieDetails(movieId);
        if (existingMovie == null) {
            return false;
        }
        movieDao.deleteById(movieId);
        return true;
    }

    @Override
    public List<Movie> getAllMovies() {
        return movieDao.findAll();
    }

    @Override
    public Page<Movie> getPaginatedMovieDetails(Pageable pageable) {
        return movieDao.findAll(pageable);
    }
}
