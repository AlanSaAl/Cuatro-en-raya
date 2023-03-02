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

    public void setPlayerToGame(Player player) throws Exception{
        if (players.size() == 2) {
            throw new Exception("Partida llena");
        }
        if (players.contains(player)) {
            throw new Exception("El jugador ya se encuentra en la partida");
        }

        this.players.add(player);
        List<Game> games = player.getGames();
        games.add(this);
        player.setGames(games);
    }
}
