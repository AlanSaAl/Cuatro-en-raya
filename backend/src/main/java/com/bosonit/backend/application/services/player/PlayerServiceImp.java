package com.bosonit.backend.application.services.player;

import com.bosonit.backend.Mappers.PlayerMapper;
import com.bosonit.backend.controllers.player.dtos.PlayerInput;
import com.bosonit.backend.controllers.player.dtos.PlayerOutput;
import com.bosonit.backend.domain.entities.Player.Player;
import com.bosonit.backend.exceptions.EntityNotFoundException;
import com.bosonit.backend.repository.PlayerRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.stream.StreamSupport;

@Service
@AllArgsConstructor
@Slf4j
public class PlayerServiceImp implements PlayerService {
    @Autowired
    private PlayerRepository playerRepository;

    //Registrar jugador, ¿devuvelve al jugador o devuelve true?
    @Override
    public PlayerOutput signUpPlayer(PlayerInput playerInput) {
        //Verificar si el jugador existe en la base de datos
        Player player = PlayerMapper.jMapper.jugadorInputToJugador(playerInput);
        String user = player.getUserName();
        if(playerRepository.findByUserName(user).isPresent()) {
            throw new EntityNotFoundException("La persona con usuario " +user + " ya existe, registre otro usuario");
        }else{
            PlayerOutput playerOutput = PlayerMapper.jMapper.jugadorToJugadorOutput(playerRepository.save(player));
            log.info("Player creado: "+ playerOutput);
            return playerOutput;
        }
    }
    //Iniciar sesión jugador, ¿devuvelve al jugador o devuelve true?
    @Override
    public PlayerOutput logInPlayer(PlayerInput playerInput){
        String userName = playerInput.getUserName();
        //Buscar jugador en bdd
        if(playerRepository.findByUserName(userName).isPresent()) {
            Player player = playerRepository.findByUserName(userName).get();
            if(playerInput.getUserPassword().equals(player.getUserPassword())){
                PlayerOutput playerOutput = PlayerMapper.jMapper.jugadorToJugadorOutput(player);
                log.info("Jugador entidad"+ player);
                log.info("Jugador encontrado"+ playerOutput);
                return playerOutput;
            }else{
                log.info("La contraseña para el usuario" +userName + " es diferente, intente nuevamente");
                throw new EntityNotFoundException("La contraseña para el usuario" +userName + " es diferente, intente nuevamente");
            }
        }else{
            log.info("Usuario no encontrado, intente nuevamente");
            throw new EntityNotFoundException("Usuario no encontrado, intente nuevamente");
        }

    }

    //--------------------------------------------------------------------------------------
    public PlayerOutput getPlayer(int idJugador) {
        Player player = playerRepository.findById(idJugador).orElseThrow();
        PlayerOutput playerOutput = PlayerMapper.jMapper.jugadorToJugadorOutput(player);
        log.info("Player obtenido: "+ playerOutput);
        return playerOutput;
    }

    @Override
    public Iterable<PlayerOutput> getAllPlayers(int pageNumber, int pageSize) {
        PageRequest pageRequest = PageRequest.of(pageNumber, pageSize);

        Iterable <Player> jugadores = playerRepository.findAll(pageRequest).getContent();
        Iterable<PlayerOutput> jugadoresOutput = StreamSupport.stream(jugadores.spliterator(),false)
                .map(player -> PlayerMapper.jMapper.jugadorToJugadorOutput(player)).toList();

        log.info("Jugadores: "+jugadoresOutput);
        return jugadoresOutput;
    }

    @Override
    public PlayerOutput updatePlayer(int idJugador, PlayerInput playerInput) {
        Player player = playerRepository.findById(idJugador).orElseThrow();
        player.setUserName(playerInput.getUserName());
        player.setUserPassword(playerInput.getUserPassword());
        PlayerOutput playerOutput = PlayerMapper.jMapper.jugadorToJugadorOutput(playerRepository.save(player));

        log.info("Player actualizado a: "+ playerOutput);
        return playerOutput;
    }

    @Override
    public void deletePlayerById(int idJugador) {
        Player player = playerRepository.findById(idJugador).orElseThrow();
        playerRepository.deleteById(idJugador);

        log.info("Player eliminado: "+ player);
    }
}
