package com.bosonit.backend.repository;

import com.bosonit.backend.domain.entities.Game.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameRepository extends JpaRepository<Game, String> {
}
