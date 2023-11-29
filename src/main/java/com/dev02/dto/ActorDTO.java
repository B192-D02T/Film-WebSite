package com.dev02.dto;

import com.dev02.domain.Actor;
import com.dev02.domain.Film;
import com.dev02.domain.enums.Gender;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class ActorDTO {

    @NotBlank(message = "Aktör ismi Girmelisiniz")
    private String name;//

    private Integer age;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    private Set<Film> filmSet = new HashSet<>();

    public ActorDTO (Actor actor){
        this.name=actor.getName();
        this.age=actor.getAge();
        this.gender=actor.getGender();

    }
}
