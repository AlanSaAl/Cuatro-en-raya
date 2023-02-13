package com.bosonit.backend.controllers.login;

import com.bosonit.backend.application.services.player.PlayerService;
import com.bosonit.backend.controllers.player.dtos.PlayerInput;
import com.bosonit.backend.controllers.player.dtos.PlayerOutput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class LoginController {
    @Autowired
    PlayerService playerService;

    //Cuando se presiona el botón de registrar jugador
    @PostMapping
    public ResponseEntity<PlayerOutput> addPlayer(@RequestBody PlayerInput playerInput) throws Exception{
        return ResponseEntity.status(HttpStatus.CREATED).body(playerService.addPlayer(playerInput));
    }

    //Cuando se presiona el botón de iniciar sesión
    @GetMapping()
    public ResponseEntity<PlayerOutput> getPlayerByCredentials(@RequestBody PlayerInput playerInput) {
        return ResponseEntity.status(HttpStatus.CREATED).body(playerService.getPlayerByCredentias(playerInput));
    }

}
