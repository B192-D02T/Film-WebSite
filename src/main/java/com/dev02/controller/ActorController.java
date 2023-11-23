package com.dev02.controller;

import com.dev02.domain.Actor;
import com.dev02.service.ActorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/actors")
@RequiredArgsConstructor
public class ActorController {

    private final ActorService actorService;

    @PostMapping("/add")//http://localhost:8080/actors/add
    public ResponseEntity<String> addActor(@Valid @RequestBody Actor actor){

        actorService.saveActor(actor);

        return new ResponseEntity<>("Aktör Ekleme Başarılı", HttpStatus.CREATED);
    }

 //Tü
}
