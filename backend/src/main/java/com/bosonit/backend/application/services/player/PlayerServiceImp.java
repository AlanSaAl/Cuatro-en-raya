package com.bosonit.backend.application.services.player;

import com.bosonit.backend.Mappers.PlayerMapper;
import com.bosonit.backend.controllers.player.dtos.PlayerInput;
import com.bosonit.backend.controllers.player.dtos.PlayerOutput;
import com.bosonit.backend.domain.entities.Player;
import com.bosonit.backend.repository.PlayerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.stream.StreamSupport;

@Service
public class PlayerServiceImp implements PlayerService {
    @Autowired
    PlayerRepository playerRepository;

    private static final Logger log = LoggerFactory.getLogger(PlayerServiceImp.class);


    @Override
    public PlayerOutput addJugador(PlayerInput playerInput) {
        Player player = PlayerMapper.jMapper.jugadorInputToJugador(playerInput);
        PlayerOutput playerOutput = PlayerMapper.jMapper.jugadorToJugadorOutput(playerRepository.save(player));
        log.info("Player creado: "+ playerOutput);
        return playerOutput;
    }

    @Override
    public PlayerOutput getJugador(int idJugador) {
        Player player = playerRepository.findById(idJugador).orElseThrow();
        PlayerOutput playerOutput = PlayerMapper.jMapper.jugadorToJugadorOutput(player);
        log.info("Player obtenido: "+ playerOutput);
        return playerOutput;
    }

    @Override
    public Iterable<PlayerOutput> getAllJugadores(int pageNumber, int pageSize) {
        PageRequest pageRequest = PageRequest.of(pageNumber, pageSize);

        Iterable <Player> jugadores = playerRepository.findAll(pageRequest).getContent();
        Iterable<PlayerOutput> jugadoresOutput = StreamSupport.stream(jugadores.spliterator(),false)
                .map(player -> PlayerMapper.jMapper.jugadorToJugadorOutput(player)).toList();

        log.info("Jugadores: "+jugadoresOutput);
        return jugadoresOutput;
    }

    @Override
    public PlayerOutput updateJugador(int idJugador, PlayerInput playerInput) {
        Player player = playerRepository.findById(idJugador).orElseThrow();
        player.setName(playerInput.getName());
        player.setPassword(playerInput.getPassword());
        PlayerOutput playerOutput = PlayerMapper.jMapper.jugadorToJugadorOutput(playerRepository.save(player));

        log.info("Player actualizado a: "+ playerOutput);
        return playerOutput;
    }

    @Override
    public void deleteJugadorById(int idJugador) {
        Player player = playerRepository.findById(idJugador).orElseThrow();
        playerRepository.deleteById(idJugador);

        log.info("Player eliminado: "+ player);
    }
}
