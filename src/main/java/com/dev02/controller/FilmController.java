package com.dev02.controller;

import com.dev02.domain.Film;
import com.dev02.service.FilmService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/films")
@RequiredArgsConstructor
public class FilmController { // deneme

    private final FilmService filmService;

    @PostMapping("/add")
    public ResponseEntity<String> addMovie(@Valid @RequestBody Film film){
        filmService.saveMovie(film);

        return new ResponseEntity<>("Filminiz Başarıyla Kayıt Edilmiştir", HttpStatus.CREATED);//201
    }


    //2-Tüm Filmleri gösterme DTO-Get--> DTO için de ID ve DATE olmıcak

    //3-Film İsmi İle Film Getirme-Tüm İsim ve İsmin Bir Kaç harfi ile

    //Film ID ile Film SİLME

    //fİLM ıd ile Film GÜNCELLEME

    //TÜM filmler PAGE olarak Gösterme

    //Aktör isminde Filmleri Getirme!!

}
