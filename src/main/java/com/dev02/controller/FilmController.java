package com.dev02.controller;

import com.dev02.domain.Film;
import com.dev02.dto.FilmDto;
import com.dev02.service.FilmService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/films")
@RequiredArgsConstructor
public class FilmController { // deneme Halil

    private final FilmService filmService;

    @PostMapping("/add")
    public ResponseEntity<String> addMovie(@Valid @RequestBody Film film){
        filmService.saveMovie(film);

        return new ResponseEntity<>("Filminiz Başarıyla Kayıt Edilmiştir", HttpStatus.CREATED);//201
    }


    //2-Tüm Filmleri gösterme DTO-Get--> DTO için de ID ve DATE olmayacak
    //Tüm Filmleri getirme -> http://localhost:8080/films + GET
    @GetMapping
    public ResponseEntity<List<FilmDto>> getAllFilms(){
        List<FilmDto> filmList=filmService.getAll();
        return ResponseEntity.ok(filmList);//200
    }

    //3-Film İsmi İle Film Getirme-Tüm İsim ve İsmin Bir Kaç harfi ile

    //Film ID ile Film SİLME

    //fİLM ıd ile Film GÜNCELLEME

    //TÜM filmler PAGE olarak Gösterme

    //Aktör isminde Filmleri Getirme

}
