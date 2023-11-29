package com.dev02.controller;

import com.dev02.domain.Actor;
import com.dev02.dto.ActorDTO;
import com.dev02.dto.FilmDTO;
import com.dev02.service.ActorService;
import com.dev02.service.FilmService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/actors")
@RequiredArgsConstructor
public class ActorController {

    private final ActorService actorService;
    private final FilmService filmService;

    @PostMapping("/add")//http://localhost:8080/actors/add
    public ResponseEntity<String> addActor(@Valid @RequestBody Actor actor){

        actorService.saveActor(actor);

        return new ResponseEntity<>("Aktör Ekleme Başarılı", HttpStatus.CREATED);
    }
    //2-Tüm Actor'leri gösterme DTO-Get--> DTO için de ID olmayacak
    @GetMapping//http://localhost:8080/actors +Get
    public ResponseEntity<List<ActorDTO>> getAllActorDto() {

        List<ActorDTO> actorList = actorService.getAllActorDTO();
        return ResponseEntity.ok(actorList);

    }
}
