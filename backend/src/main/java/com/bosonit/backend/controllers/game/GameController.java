package com.bosonit.backend.controllers.game;

import com.bosonit.backend.application.services.game.GameService;
import com.bosonit.backend.application.services.game.GameServiceImpl;
import com.bosonit.backend.controllers.game.dtos.GameOutput;
import com.bosonit.backend.controllers.game.dtos.JoinGameInput;
import com.bosonit.backend.controllers.game.dtos.JoinGameOutput;
import com.bosonit.backend.controllers.player.dtos.PlayerInput;
import com.bosonit.backend.domain.entities.Player.Player;
import lombok.AllArgsConstructor;

import org.springframework.data.util.Pair;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/juego")
public class GameController {

    private GameServiceImpl juegoService;

    private GameService gameService;

    private SimpMessagingTemplate simpMessagingTemplate;
/*
    @PostMapping("/jugador1")
    public ResponseEntity<?> addTiro1(@RequestBody Game game) throws Exception{
       juegoService.tiroJugadorUno(game.getX(), game.getY());
        System.out.println(juegoService.matriz);
        return ResponseEntity.status(HttpStatus.OK).body("Tiro registrado");
    }

    @PostMapping("/jugador2")
    public ResponseEntity<?> addTiro2(@RequestBody Game game) throws Exception{
        juegoService.tiroJugadorDos(game.getX(), game.getY());
        System.out.println(juegoService.matriz);
        return ResponseEntity.status(HttpStatus.OK).body("Tiro registrado");
    }

    @GetMapping("/ganador")
    public ResponseEntity<?> revisarGanador(@RequestBody Game game) throws Exception{
        return ResponseEntity.status(HttpStatus.OK).body(juegoService.revisarTablero(this.juegoService.matriz));
    } */

    @PostMapping("/crear")
    public ResponseEntity<GameOutput> crearJuego(@RequestBody PlayerInput playerInput) {
        return ResponseEntity.ok(gameService.crearJuego(playerInput));
    }

    @PatchMapping("/join")
    public void joinGame(@RequestBody JoinGameInput joinGameInput) throws Exception{
        Pair<Player, Optional<Integer>> players = gameService.joinGame(joinGameInput.getIdPlayer(), joinGameInput.getIdGame());
        JoinGameOutput joinGameOutput = new JoinGameOutput(players.getFirst(), players.getSecond());
        simpMessagingTemplate.convertAndSend("/game-notifications/" + joinGameInput.getIdGame(), joinGameOutput);
    }
}