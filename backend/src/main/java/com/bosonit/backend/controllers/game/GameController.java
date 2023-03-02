package com.bosonit.backend.controllers.game;

import com.bosonit.backend.application.services.game.GameService;
import com.bosonit.backend.application.services.game.GameServiceImpl;
import com.bosonit.backend.controllers.game.dtos.GameInput;
import com.bosonit.backend.controllers.game.dtos.GameOutput;
import com.bosonit.backend.controllers.player.dtos.PlayerInput;
import com.bosonit.backend.domain.entities.Game.Game;
import com.bosonit.backend.domain.entities.Player.Player;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private GameServiceImpl gameService;
    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    @Operation(summary = "Se crea un nuevo juego cuando un jugador accede a este endpoint")
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public GameOutput addGame(@RequestBody GameInput gameInput) {
        return gameService.addGame(gameInput.getIdPlayer1());
    }

    @PatchMapping("join")
    public void joinGame(Player player, @RequestBody GameInput gameInput) throws Exception {
        Pair<Player, Optional<Integer>> players = gameService.joinGame(gameInput.getIdGame(), player.getUserName());


        Player secondPlayer = players.getFirst();

        Optional<Integer> optionalFirstPlayerId = players.getSecond();

        GamePatchResponse gamePatchResponse = new GamePatchResponse(secondPlayer,optionalFirstPlayerId);

        simpMessagingTemplate.convertAndSend("/game-notifications/" + gameInput.getIdGame(), gamePatchResponse);
    }

    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    @Setter
    class GamePatchRequest {
        private int gameId;
    }

    @NoArgsConstructor
    @Getter
    @Setter
    class GamePatchResponse {
        private GamePatchPlayerResponse joinedPlayer; //JugadorInput
        private int startingPlayerId; //JugadorInput.getId(); int

        public GamePatchResponse(Player joinedPlayer, Optional<Integer> optionalFirstPlayerId) {
            this.joinedPlayer = new GamePatchPlayerResponse(joinedPlayer); //PlayerOutput segundo jugador
            this.startingPlayerId = optionalFirstPlayerId.orElse(-1);
        }
    }

    @Getter
    @Setter
    class GamePatchPlayerResponse {
        private int playerId;
        private String name;

        public GamePatchPlayerResponse(Player firstPlayer) {
            this.playerId = firstPlayer.getIdPlayer();
            this.name = firstPlayer.getUserName();
        }
    }

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

    /*
    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/crear")
    public ResponseEntity<GameOutput> crearJuego(@RequestBody PlayerInput playerInput) {
        log.info("solicitud para crear juego: {}", playerInput);
        return ResponseEntity.ok(gameService.crearJuego(playerInput));
    }

     */
}