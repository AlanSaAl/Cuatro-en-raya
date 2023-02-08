package com.bosonit.backend.controllers.game.dtos;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ShotOutput {
    private int x_shot;
    private int y_shot;
    private Integer numPlayer;
}
