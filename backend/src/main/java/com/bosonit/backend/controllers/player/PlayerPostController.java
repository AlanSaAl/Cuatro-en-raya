package com.bosonit.backend.controllers.player;

import com.bosonit.backend.application.services.player.PlayerService;
import com.bosonit.backend.controllers.player.dtos.PlayerInput;
import com.bosonit.backend.controllers.player.dtos.PlayerOutput;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/signup")
public class PlayerPostController {

    private PlayerService playerService;

    @PostMapping
    public PlayerOutput signUpPlayer(@RequestBody PlayerInput playerInput) {
        return playerService.signUpPlayer(playerInput);
    }
}
