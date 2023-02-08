package com.bosonit.backend.controllers.game.dtos;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ShotInput {
    public int xShot;
    public int yShot;
    public Integer numPlayer;
    public Integer idPlayer;
    public Integer idGame;
}
