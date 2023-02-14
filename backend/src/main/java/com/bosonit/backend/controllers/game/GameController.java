package com.bosonit.backend.controllers.game;

import com.bosonit.backend.application.services.game.GameService;
import com.bosonit.backend.application.services.game.GameServiceImpl;
import com.bosonit.backend.controllers.game.dtos.GameOutput;
import com.bosonit.backend.controllers.player.dtos.PlayerInput;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("/juego")
public class GameController {

    private GameServiceImpl juegoService;

    @Autowired
    private GameService gameService;
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

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/crear")
    public ResponseEntity<GameOutput> crearJuego(@RequestBody PlayerInput playerInput) {
        log.info("solicitud para crear juego: {}", playerInput);
        return ResponseEntity.ok(gameService.crearJuego(playerInput));
    }
}