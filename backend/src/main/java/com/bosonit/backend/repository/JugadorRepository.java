package com.bosonit.backend.repository;

import com.bosonit.backend.jugador.domain.entity.Jugador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JugadorRepository extends JpaRepository<Jugador,Integer> {
}
