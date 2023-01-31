package com.bosonit.backend.application.services;

import com.bosonit.backend.dtos.JugadorInput;
import com.bosonit.backend.dtos.JugadorOutput;

public interface JugadorService {
    JugadorOutput addJugador(JugadorInput jugadorInput);
    JugadorOutput getJugador(int idJugador);
    Iterable<JugadorOutput> getAllJugadores(int pageNumber, int pageSize);
    JugadorOutput updateJugador(int idJugador, JugadorInput jugadorInput);
    void deleteJugadorById(int idJugador);
}
