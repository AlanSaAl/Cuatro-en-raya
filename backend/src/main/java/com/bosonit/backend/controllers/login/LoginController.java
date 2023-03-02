package com.bosonit.backend.controllers.login;

import com.bosonit.backend.application.services.player.PlayerService;
import com.bosonit.backend.controllers.player.dtos.PlayerInput;
import com.bosonit.backend.controllers.player.dtos.PlayerOutput;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
@AllArgsConstructor
public class LoginController {
    @Autowired
    private PlayerService playerService;

    @Operation(summary = "Cuando se presiona el botón de registrar jugador")
    @PostMapping
    public ResponseEntity<PlayerOutput> signUpPlayer(@RequestBody PlayerInput playerInput) throws Exception{
        return ResponseEntity.status(HttpStatus.CREATED).body(playerService.signUpPlayer(playerInput));
    }


    @Operation(summary = "Cuando se presiona el botón de iniciar sesión")
    @GetMapping()
    public ResponseEntity<PlayerOutput> logInPlayer(@RequestBody PlayerInput playerInput) {
        return ResponseEntity.status(HttpStatus.CREATED).body(playerService.logInPlayer(playerInput));
    }

}
