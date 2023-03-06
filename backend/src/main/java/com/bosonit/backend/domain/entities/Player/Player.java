package com.bosonit.backend.domain.entities.Player;

import com.bosonit.backend.domain.entities.Game.Game;
import lombok.*;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="player")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_player",nullable = false)
    public int idPlayer;

    @Column(name = "user_name")
    public String userName;

    @Column(name = "user_password")
    public String userPassword;

    @ManyToMany(fetch = FetchType.LAZY)
    private List<Game> games = new ArrayList<Game>();

    @OneToMany(mappedBy = "winner", fetch = FetchType.EAGER)
    private List<Game> wonGames = new ArrayList<Game>();

    public void addGame(Game game){
        this.games.add(game);
    }

    public void addWonGame(Game game){
        this.wonGames.add(game);
    }
}
