package com.dev02.service;

import com.dev02.domain.Film;
import com.dev02.exception.ConflictException;
import com.dev02.repository.FilmRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FilmService {

    private final FilmRepo filmRepo;
    public void saveMovie(Film film) {

        boolean isExist=filmRepo.existsByMovieName(film.getMovieName());

        if (isExist){//böyle bir film varsa
            throw new ConflictException("Bu İsimde Bir Film Vardır.Ekleme Başarısız!!");
        }

        //yoksa ekle
        filmRepo.save(film);

    }
}
