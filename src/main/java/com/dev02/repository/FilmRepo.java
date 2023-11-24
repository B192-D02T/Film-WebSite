package com.dev02.repository;

import com.dev02.domain.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FilmRepo extends JpaRepository<Film, Long> {

    boolean existsByMovieName(String title);

    Optional<List<Film>> findByMovieNameContaining(String word);
    @Query(value = "SELECT * FROM  tbl_film f WHERE f.movie_name ILIKE %:pword%",nativeQuery = true)//SQL
    Optional<List<Film>> findByMovieNameContainingJPQL(@Param("pword") String word);
}
