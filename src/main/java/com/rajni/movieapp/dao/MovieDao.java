package com.rajni.movieapp.dao;

import com.rajni.movieapp.entities.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieDao extends JpaRepository<Movie, Integer> {
}
