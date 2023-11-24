package com.dev02.dto;

import com.dev02.domain.Film;
import com.dev02.domain.enums.CategoryType;
import com.dev02.domain.enums.LanguageName;
import com.dev02.domain.Actor;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor

public class FilmDTO {


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
    public FilmDTO(Film film){
        this.movieName=film.getMovieName();
        this.relaseYear= film.getRelaseYear();
        this.imdbScore= film.getImdbScore();
        this.length= film.getLength();
        this.actorSet=film.getActorSet();
        this.languageName=film.getLanguageName();
        this.categoryType=film.getCategoryType();

    }

}



