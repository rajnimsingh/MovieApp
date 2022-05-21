package com.rajni.movieapp.controller;

import com.rajni.movieapp.dtos.MovieDTO;
import com.rajni.movieapp.entities.Movie;
import com.rajni.movieapp.service.MovieService;
import com.rajni.movieapp.util.MovieDTOToMovieEntityAdapter;
import com.rajni.movieapp.util.MovieEntityToMovieDTOAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/movie_app/v1")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @Autowired
    private MovieDTOToMovieEntityAdapter dtoToEntityConverterForMovies;

    @Autowired
    private MovieEntityToMovieDTOAdapter entityToMovieDTOAdapter;

    @GetMapping("/ping")
    public String ping() {
        return "PING SUCCESSFUL";
    }

    @PostMapping(value = "/movie", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<MovieDTO> createMovie(@RequestBody MovieDTO movieDTO) {
        Movie movie = dtoToEntityConverterForMovies.convertFrom(movieDTO);
        movie = movieService.acceptMovieDetails(movie);
        MovieDTO dto = entityToMovieDTOAdapter.convertFrom(movie);
        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }

    @GetMapping(value = "/movies", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<MovieDTO>> getAllMovies() {
        List<Movie> movies = movieService.getAllMovies();
        List<MovieDTO> movieDTOs = new ArrayList<>();
        movies.forEach(m -> movieDTOs.add(entityToMovieDTOAdapter.convertFrom(m)));
        return new ResponseEntity<>(movieDTOs, HttpStatus.ACCEPTED);
    }

    @GetMapping(value = "/movies/{movieID}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<MovieDTO> getMovieByID(@PathVariable("movieID") Integer movieID) {
        Movie movie = movieService.getMovieDetails(movieID);
        MovieDTO result = entityToMovieDTOAdapter.convertFrom(movie);
        return new ResponseEntity<>(result, HttpStatus.ACCEPTED);
    }

    @PutMapping(value = "/movie/{movieID}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<MovieDTO> updateMovie(@PathVariable("movieID") Integer movieID, @RequestBody MovieDTO movieDTO) {
        Movie existingDetails = movieService.getMovieDetails(movieID);
        if(existingDetails != null) {
            Movie toBeUpdated = dtoToEntityConverterForMovies.convertFrom(movieDTO);
            toBeUpdated = movieService.updateMovieDetails(movieID, toBeUpdated);
            MovieDTO dto = entityToMovieDTOAdapter.convertFrom(toBeUpdated);
            return new ResponseEntity<>(dto, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.PRECONDITION_FAILED);
    }


    @DeleteMapping(value = "/movie/{movieID}")
    public ResponseEntity<Boolean> deleteMovie(@PathVariable("movieID") int movieID) {
        return new ResponseEntity<>(movieService.deleteMovie(movieID), HttpStatus.OK);
    }

}
