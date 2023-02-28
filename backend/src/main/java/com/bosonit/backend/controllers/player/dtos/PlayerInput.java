package com.bosonit.backend.controllers.player.dtos;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PlayerInput {
    private int idPlayer;

    private String userName;

    private String userPassword;
}
