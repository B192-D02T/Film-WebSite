package com.dev02.controller;

import com.dev02.domain.Actor;
import com.dev02.domain.Film;
import com.dev02.dto.FilmDTO;
import com.dev02.service.ActorService;
import com.dev02.service.FilmService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/films")
@RequiredArgsConstructor
public class FilmController {

    private final FilmService filmService;
    private final ActorService actorService;

    //1-Film ekleme
    @PostMapping("/add")//http://localhost:8080/films/add  +POST +JSON
    public ResponseEntity<String> addMovie(@Valid @RequestBody Film film) {
        filmService.saveMovie(film);

        return new ResponseEntity<>("Filminiz Başarıyla Kayıt Edilmiştir", HttpStatus.CREATED);//201
    }


    //2-Tüm Filmleri gösterme DTO-Get--> DTO için de ID ve DATE olmıcak
    @GetMapping//http://localhost:8080/films +Get
    public ResponseEntity<List<FilmDTO>> getAllFilmDto() {

        List<FilmDTO> filmList = filmService.getAllDTO();
        return ResponseEntity.ok(filmList);
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


    //5-fİLM ıd ile Film GÜNCELLEME
    @PutMapping("/update/{id}")//http://localhost:8080/films/update/1
    public ResponseEntity<String> updateFilm(@PathVariable Long id, @RequestBody FilmDTO filmDTO) {

        filmService.updateFilmById(id, filmDTO);

        return ResponseEntity.ok("Customer is updated successfully...");
    }

    //6-TÜM filmler PAGE olarak Gösterme

    @GetMapping("/page")//http://localhost:8080/films/page
    public ResponseEntity<Page<Film>> getAllByPage(@RequestParam("page") int page,//kaçıncı sayfa
                                                   @RequestParam("size") int size,//her sayfada kaç bilgi ar
                                                   @RequestParam("sort") String prop,//hangi değişken
                                                   @RequestParam("direction") Sort.Direction direction) {//değişken şekli

        Pageable pageable = PageRequest.of(page, size, Sort.by(direction, prop));
        Page<Film> allFilms = filmService.getAllCustomerByPage(pageable);
        return ResponseEntity.ok(allFilms);
    }


    //7- ID'si verilen Aktörün Filmleri Getirme
    @GetMapping("/allorder/{id}")//http://localhost:8080/films/allorder/1
    public ResponseEntity<Set<Film>> getAllOrdersByActorId(@PathVariable Long id) {

        Actor actor = actorService.getActorById(id);//Aktörü bulma

        Set<Film> actorFilmSet = actor.getFilmSet();//filmlerini getiriyoruz


        return ResponseEntity.ok(actorFilmSet);
    }
}
