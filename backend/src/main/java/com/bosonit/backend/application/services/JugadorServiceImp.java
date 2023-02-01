package com.bosonit.backend.application.services;

import com.bosonit.backend.Mappers.JugadorMapper;
import com.bosonit.backend.dtos.JugadorInput;
import com.bosonit.backend.dtos.JugadorOutput;
import com.bosonit.backend.jugador.domain.entity.Jugador;
import com.bosonit.backend.repository.JugadorRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.stream.StreamSupport;

@Service
public class JugadorServiceImp implements JugadorService{
    @Autowired
    JugadorRepository jugadorRepository;

    private static final Logger log = LoggerFactory.getLogger(JugadorServiceImp.class);


    @Override
    public JugadorOutput addJugador(JugadorInput jugadorInput) {
        Jugador jugador = JugadorMapper.jMapper.jugadorInputToJugador(jugadorInput);
        JugadorOutput jugadorOutput = JugadorMapper.jMapper.jugadorToJugadorOutput(jugadorRepository.save(jugador));
        log.info("Jugador creado: "+jugadorOutput);
        return jugadorOutput;
    }

    @Override
    public JugadorOutput getJugador(int idJugador) {
        Jugador jugador = jugadorRepository.findById(idJugador).orElseThrow();
        JugadorOutput jugadorOutput = JugadorMapper.jMapper.jugadorToJugadorOutput(jugador);
        log.info("Jugador obtenido: "+jugadorOutput);
        return jugadorOutput;
    }

    @Override
    public Iterable<JugadorOutput> getAllJugadores(int pageNumber, int pageSize) {
        PageRequest pageRequest = PageRequest.of(pageNumber, pageSize);

        Iterable <Jugador> jugadores = jugadorRepository.findAll(pageRequest).getContent();
        Iterable<JugadorOutput> jugadoresOutput = StreamSupport.stream(jugadores.spliterator(),false)
                .map(jugador -> JugadorMapper.jMapper.jugadorToJugadorOutput(jugador)).toList();

        log.info("Jugadores: "+jugadoresOutput);
        return jugadoresOutput;
    }

    @Override
    public JugadorOutput updateJugador(int idJugador, JugadorInput jugadorInput) {
        Jugador jugador = jugadorRepository.findById(idJugador).orElseThrow();
        jugador.setName(jugadorInput.getName());
        jugador.setPassword(jugadorInput.getPassword());
        JugadorOutput jugadorOutput = JugadorMapper.jMapper.jugadorToJugadorOutput(jugadorRepository.save(jugador));

        log.info("Jugador actualizado a: "+jugadorOutput);
        return jugadorOutput;
    }

    @Override
    public void deleteJugadorById(int idJugador) {
        Jugador jugador = jugadorRepository.findById(idJugador).orElseThrow();
        jugadorRepository.deleteById(idJugador);

        log.info("Jugador eliminado: "+jugador);
    }
}
