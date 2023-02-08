package com.bosonit.backend.domain.entities.Game;

import com.bosonit.backend.domain.entities.Player.Player;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name="game")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_game")
    public int idGame;

    //Una partida puede tener varios tiros
    @OneToMany(mappedBy = "game",cascade = CascadeType.ALL)
    public List<Shot> shotsList = new ArrayList<>();

    //Muchas partidas pueden tener un jugador (ganador)
    @ManyToOne
    @JoinColumn(name = "id_player")
    public Player player;
}
