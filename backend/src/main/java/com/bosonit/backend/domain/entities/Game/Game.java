package com.bosonit.backend.domain.entities.Game;

import com.bosonit.backend.domain.entities.Player.Player;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="games")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Game implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_game", nullable = false)
    public Integer idGame;

    @Column(name = "game")
    @ManyToMany(mappedBy = "games",fetch = FetchType.EAGER)
    private List<Player> players = new ArrayList<Player>();

    @ManyToOne(fetch = FetchType.EAGER)
    private Player winner;

    @Column(name = "shots")
    @OneToMany(mappedBy = "game",fetch = FetchType.EAGER)
    private List<Shot> shots = new ArrayList<Shot>();

    private boolean finished;

    private static final int MAX_PLAYERS = 2;

    public void addPlayer(Player player){
        this.players.add(player);
    }

    public void addShot(Shot shot){
        shots.add(shot);
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    private static final long serialVersionUID = 1L;

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
