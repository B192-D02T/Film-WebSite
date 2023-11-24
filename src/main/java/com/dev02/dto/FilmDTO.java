package com.dev02.dto;

import com.dev02.domain.Actor;
import com.dev02.domain.Film;
import com.dev02.domain.enums.CategoryType;
import com.dev02.domain.enums.LanguageName;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class FilmDTO {

    private String movieName;

    private Integer relaseYear;

    private Double imdbScore;

    private Integer length;


    private Set<Actor> actorSet = new HashSet<>();

    private LanguageName languageName;

    private CategoryType categoryType;

    public FilmDTO (Film film){
        this.movieName=film.getMovieName();
        this.relaseYear= film.getRelaseYear();
        this.imdbScore= film.getImdbScore();
        this.length= film.getLength();
        this.actorSet=film.getActorSet();
        this.languageName=film.getLanguageName();
        this.categoryType=film.getCategoryType();

    }

}
