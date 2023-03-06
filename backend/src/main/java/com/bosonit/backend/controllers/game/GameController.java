package com.bosonit.backend.controllers.game;

import com.bosonit.backend.application.services.game.GameServiceImpl;
import com.bosonit.backend.controllers.game.dtos.GameInput;
import com.bosonit.backend.controllers.game.dtos.GameOutput;
import com.bosonit.backend.controllers.game.dtos.JoinGameInput;
import com.bosonit.backend.controllers.game.dtos.JoinGameOutput;
import com.bosonit.backend.controllers.player.dtos.PlayerInput;
import com.bosonit.backend.domain.entities.Player.Player;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.util.Pair;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("/juego")
public class GameController {

    private GameServiceImpl juegoService;

    private GameServiceImpl gameService;

    private SimpMessagingTemplate simpMessagingTemplate;

    @Operation(summary = "Se crea un nuevo juego cuando un jugador accede a este endpoint")
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public GameOutput addGame(@RequestBody GameInput gameInput) {
        return gameService.addGame(gameInput.getIdPlayer1());
    }

    @PostMapping("/crear")
    public ResponseEntity<GameOutput> crearJuego(@RequestBody PlayerInput playerInput) {
        return ResponseEntity.ok(gameService.crearJuego(playerInput));
    }

    @PatchMapping("join")
    public void joinGame(@RequestBody JoinGameInput joinGameInput) throws Exception{
        Pair<Player, Optional<Integer>> players = gameService.joinGame(joinGameInput.getIdPlayer(), joinGameInput.getIdGame());
        JoinGameOutput joinGameOutput = new JoinGameOutput(players.getFirst(), players.getSecond());
        simpMessagingTemplate.convertAndSend("/game-notifications/" + joinGameInput.getIdGame(), joinGameOutput);
    }
}