package com.dev02.controller;

import com.dev02.domain.Film;
import com.dev02.dto.FilmDTO;
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
    public ResponseEntity<List<FilmDTO>> getAllFilms(){
        List<FilmDTO> filmList=filmService.getAll();
        return ResponseEntity.ok(filmList);//200
    }

    //3-Film İsmi İle Film Getirme-Tüm İsim ve İsmin Bir Kaç harfi ile

    @GetMapping("/filmsDTO")//http://localhost:8080/films/filmsDTO?word=Ti +GET
    public ResponseEntity<List<FilmDTO>> getFilmByNameLike(@RequestParam("word") String word) {
        List<FilmDTO> filmDTOList = filmService.getFilmDTOByMovieNameLike(word);

        return ResponseEntity.ok(filmDTOList);
    }
    //4-Film ID ile Film SİLME
    @DeleteMapping("/filmdDelete") //http://localhost:8080/films/filmdDelete?id=1
    public ResponseEntity<String> deleteFilmById(@RequestParam("id") Long id) {

        filmService.deleteFilmById(id);

        return ResponseEntity.ok("Film Başarıyla Silindi");//200
    }
    //fİLM ıd ile Film GÜNCELLEME

    //TÜM filmler PAGE olarak Gösterme

    //Aktör isminde Filmleri Getirme

}
