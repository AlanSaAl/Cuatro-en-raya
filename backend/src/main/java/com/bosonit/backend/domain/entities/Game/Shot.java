package com.bosonit.backend.domain.entities.Game;

import com.bosonit.backend.domain.entities.Player.Player;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name="shot")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Shot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_shot")
    public int idShot;

    @Column(name = "shot_value")
    public Integer shotValue = null;

    //Muchos tiros pueden tener sólo 1 partida
    @ManyToOne
    @JoinColumn(name = "id_game")
    public Game game;

    //Muchos tiros pueden tener sólo 1 jugador
    @ManyToOne
    @JoinColumn(name = "id_player")
    public Player player;
}
