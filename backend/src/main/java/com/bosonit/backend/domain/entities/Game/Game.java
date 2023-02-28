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
    @GeneratedValue
    @Column(name = "id_game")
    private int idGame;

    @ManyToMany(mappedBy = "games")
    private List<Player> players = new ArrayList<>();

    @Column(name = "id_winner")
    private int idWinner;
}
