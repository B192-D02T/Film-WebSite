package com.dev02.repository;

import com.dev02.domain.Actor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActorRepo  extends JpaRepository<Actor,Long> {
    boolean existsByName(String name);
}
