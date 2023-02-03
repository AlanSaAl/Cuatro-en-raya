package com.bosonit.backend.controllers.player;


import com.bosonit.backend.application.services.player.PlayerService;
import com.bosonit.backend.controllers.player.dtos.PlayerInput;
import com.bosonit.backend.controllers.player.dtos.PlayerOutput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/jugador")
public class PlayerController {
    @Autowired
    PlayerService playerService;

    @PostMapping
    public ResponseEntity<PlayerOutput> addCliente(@RequestBody PlayerInput playerInput) throws Exception{
        PlayerOutput playerOutput = playerService.addJugador(playerInput);
        return ResponseEntity.status(HttpStatus.CREATED).body(playerOutput);
    }

    @GetMapping("/jugadores")
    public ResponseEntity<Iterable<PlayerOutput>>getAllJugadores(@RequestParam(defaultValue = "0", required = false) int pageNumber,
                                                                 @RequestParam(defaultValue = "4", required = false) int pageSize) {
        Iterable<PlayerOutput>  jugadoresOutput = playerService.getAllJugadores(pageNumber,pageSize);
        return ResponseEntity.status(HttpStatus.OK).body(jugadoresOutput);
    }

    @GetMapping("/id/{idJugador}")
    public ResponseEntity<PlayerOutput> getJugadorById(@PathVariable int idJugador)
    {
        PlayerOutput playerOutput = playerService.getJugador(idJugador);
        return ResponseEntity.status(HttpStatus.OK).body(playerOutput);
    }


    @PutMapping("/update/{idJugador}")
    public ResponseEntity<PlayerOutput> updateJugador(@RequestBody PlayerInput playerInput,
                                                      @PathVariable int idJugador) {
        PlayerOutput playerOutput = playerService.updateJugador(idJugador, playerInput);
        return ResponseEntity.status(HttpStatus.OK).body(playerOutput);
    }

    @DeleteMapping("delete/{idJugador}")
    public ResponseEntity<PlayerOutput> deleteJugador(@PathVariable int idJugador) {
        PlayerOutput playerOutput = playerService.getJugador(idJugador);
        playerService.deleteJugadorById(idJugador);
        return ResponseEntity.status(HttpStatus.OK).body(playerOutput);
    }

}
