package com.bosonit.backend.controllers.login;

import com.bosonit.backend.application.services.player.PlayerService;
import com.bosonit.backend.controllers.player.dtos.PlayerInput;
import com.bosonit.backend.controllers.player.dtos.PlayerOutput;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class LoginController {

    private PlayerService playerService;

    @PostMapping("/signup")
    public ResponseEntity<PlayerOutput> signUpPlayer(@RequestBody PlayerInput playerInput) throws Exception{
        return ResponseEntity.status(HttpStatus.CREATED).body(playerService.signUpPlayer(playerInput));
    }

    @PostMapping("/login")
    public ResponseEntity<PlayerOutput> logInPlayer(@RequestBody PlayerInput playerInput) {
        return ResponseEntity.status(HttpStatus.OK).body(playerService.logInPlayer(playerInput));
    }

}
