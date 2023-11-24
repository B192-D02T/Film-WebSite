package com.dev02.dto;

import com.dev02.domain.Film;
import com.dev02.domain.enums.Gender;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.dev02.domain.enums.CategoryType;
import com.dev02.domain.enums.LanguageName;
import com.dev02.domain.Actor;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor

public class FilmDto {


    @NotBlank(message = "Film ismi Girmelisiniz")
    private String movieName;

    private Integer relaseYear;

    private Double imdbScore;

    private Integer length;

    @Enumerated(EnumType.STRING)
    private LanguageName languageName;

    @Enumerated(EnumType.STRING)
    private CategoryType categoryType;

    private Set<Actor> actorSet = new HashSet<>();
    public FilmDto (Film film){
        this.movieName=film.getMovieName();
        this.relaseYear= film.getRelaseYear();
        this.imdbScore= film.getImdbScore();
        this.length= film.getLength();
        this.actorSet=film.getActorSet();
        this.languageName=film.getLanguageName();
        this.categoryType=film.getCategoryType();

    }

}



