package com.bosonit.backend.controllers.player;

import com.bosonit.backend.application.services.player.PlayerService;
import com.bosonit.backend.controllers.player.dtos.PlayerInput;
import com.bosonit.backend.controllers.player.dtos.PlayerOutput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/player")
public class PlayerController {
    @Autowired
    PlayerService playerService;

    @GetMapping("/players")
    public ResponseEntity<Iterable<PlayerOutput>>getAllPlayers(@RequestParam(defaultValue = "0", required = false) int pageNumber,
                                                                 @RequestParam(defaultValue = "4", required = false) int pageSize) {
        Iterable<PlayerOutput>  jugadoresOutput = playerService.getAllPlayers(pageNumber,pageSize);
        return ResponseEntity.status(HttpStatus.OK).body(jugadoresOutput);
    }

    @GetMapping("/id/{idPlayer}")
    public ResponseEntity<PlayerOutput> getPlayerById(@PathVariable int idPlayer)
    {
        PlayerOutput playerOutput = playerService.getPlayer(idPlayer);
        return ResponseEntity.status(HttpStatus.OK).body(playerOutput);
    }


    @PutMapping("/update/{idPlayer}")
    public ResponseEntity<PlayerOutput> updtatePlayer(@RequestBody PlayerInput playerInput,
                                                      @PathVariable int idPlayer) {
        PlayerOutput playerOutput = playerService.updatePlayer(idPlayer, playerInput);
        return ResponseEntity.status(HttpStatus.OK).body(playerOutput);
    }

    @DeleteMapping("delete/{idPlayer}")
    public ResponseEntity<PlayerOutput> deletePlayer(@PathVariable int idPlayer) {
        PlayerOutput playerOutput = playerService.getPlayer(idPlayer);
        playerService.deletePlayerById(idPlayer);
        return ResponseEntity.status(HttpStatus.OK).body(playerOutput);
    }

}
