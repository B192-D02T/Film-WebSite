package com.dev02.service;

import com.dev02.domain.Actor;
import com.dev02.domain.Film;
import com.dev02.dto.ActorDTO;
import com.dev02.dto.FilmDTO;
import com.dev02.exception.ConflictException;
import com.dev02.exception.ResourceNotFoundException;
import com.dev02.repository.ActorRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ActorService {

    private final ActorRepo actorRepo;

    public void saveActor(Actor actor) {

        boolean isExist=actorRepo.existsByName(actor.getName());

        if (isExist){
            throw new ConflictException("Girdiğiniz Aktör isminde bir Aktör vardır.");
        }

        actorRepo.save(actor);

    }

    public Actor getActorById(Long id) {
        Actor actor=actorRepo.findById(id).
                orElseThrow(()->new ResourceNotFoundException("Girdiğiniz ID ile Bir Aktör bulunamamıştır"));

        return actor;
    }
    //2-B Get All Actor
    public List<Actor> getAll() {
        return actorRepo.findAll();
    }
    public List<ActorDTO> getAllActorDTO() {
        List<Actor> actorList = getAll();
        List<ActorDTO> actorDTOList = new ArrayList<>();

        for (Actor actor : actorList) {

            ActorDTO actorDTO = new ActorDTO(actor);
            actorDTOList.add(actorDTO);

        }
        return actorDTOList;
    }
}
