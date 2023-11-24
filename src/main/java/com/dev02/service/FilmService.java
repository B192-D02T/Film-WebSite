package com.dev02.service;

import com.dev02.domain.Film;
import com.dev02.dto.FilmDto;
import com.dev02.exception.ConflictException;
import com.dev02.repository.FilmRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

    //Tüm Filmleri getirme
    public List<FilmDto> getAll() {
        List<Film> filmList=filmRepo.findAll();//"FROM Film"
        List<FilmDto> filmDtoList=new ArrayList<>();

        for (Film film:filmList){
            FilmDto filmDto=new FilmDto(film);
            filmDtoList.add(filmDto);
        }

        return filmDtoList;

    }
}
