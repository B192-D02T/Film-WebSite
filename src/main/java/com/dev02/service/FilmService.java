package com.dev02.service;

import com.dev02.domain.Film;
import com.dev02.dto.FilmDTO;
import com.dev02.exception.ConflictException;
import com.dev02.exception.ResourceNotFoundException;
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
    public List<FilmDTO> getAll() {
        List<Film> filmList=filmRepo.findAll();//"FROM Film"
        List<FilmDTO> filmDTOList =new ArrayList<>();

        for (Film film:filmList){
            FilmDTO filmDto=new FilmDTO(film);
            filmDTOList.add(filmDto);
        }

        return filmDTOList;

    }

    //3-B
    public List<FilmDTO> getFilmDTOByMovieNameLike(String word) {

        List<Film> filmList = filmRepo.findByMovieNameContainingJPQL(word).
                orElseThrow(() -> new ResourceNotFoundException("Girdiğiniz Bilgilerde Film Bulunamadı.."));

        List<FilmDTO> filmDTOList = new ArrayList<>();

        for (Film film : filmList) {

            FilmDTO filmDTO = new FilmDTO(film);
            filmDTOList.add(filmDTO);
        }
        return filmDTOList;
    }
    //3-C
    public List<Film> getFilmByMovieNameLike(String word) {
        return filmRepo.findByMovieNameContaining(word).
                orElseThrow(() -> new ResourceNotFoundException("Girdiğiniz Bilgilerde Film Bulunamadı.."));
    }
    public Film findFilmById(Long id) {
        return filmRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Girdiğiniz ID'de Film Bulunamadı.."));

}
    //4
    public void deleteFilmById(Long id) {
        findFilmById(id);
        filmRepo.deleteById(id);

    }
    public void updateFilmById(Long id, FilmDTO filmDTO) {

        Film foundFilm = findFilmById(id);//böyle bir film var mı

        //film isimleri unıq olduğu için kontrolü buradan yapıyoruz
        boolean isExist = filmRepo.existsByMovieName(filmDTO.getMovieName());//kullanıcıdan aldığımız json dosyasındaki film ismi var mı

        if (isExist && !filmDTO.getMovieName().equals(foundFilm.getMovieName())) {//kullanıcının verdiği film ismi ile id ile geln film ismi aynı değilse
            //film varsa
            throw new ConflictException("Girdiğiniz Film İsmi Mevcut :" + filmDTO.getMovieName());

        }

        foundFilm.setMovieName(filmDTO.getMovieName());
        foundFilm.setRelaseYear(filmDTO.getRelaseYear());
        foundFilm.setImdbScore(filmDTO.getImdbScore());
        foundFilm.setLength(filmDTO.getLength());
        foundFilm.setActorSet(filmDTO.getActorSet());
        foundFilm.setLanguageName(filmDTO.getLanguageName());
        foundFilm.setCategoryType(filmDTO.getCategoryType());

        filmRepo.save(foundFilm);

}
}
