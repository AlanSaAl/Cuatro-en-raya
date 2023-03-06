package com.bosonit.backend.repository;

import com.bosonit.backend.domain.entities.Game.Shot;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShotRepository extends JpaRepository<Shot, Long> {
}
