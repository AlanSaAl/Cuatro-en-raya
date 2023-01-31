package com.bosonit.backend.Mappers;

import com.bosonit.backend.dtos.JugadorInput;
import com.bosonit.backend.dtos.JugadorOutput;
import com.bosonit.backend.jugador.domain.entity.Jugador;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
@Mapper
public interface JugadorMapper {
    JugadorMapper jMapper = Mappers.getMapper(JugadorMapper.class);

    Jugador jugadorInputToJugador(JugadorInput jugadorInput);
    JugadorOutput jugadorToJugadorOutput(Jugador jugador);
}
