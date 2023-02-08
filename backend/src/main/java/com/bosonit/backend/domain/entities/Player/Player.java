package com.bosonit.backend.domain.entities.Player;

import com.bosonit.backend.domain.entities.Game.Game;
import com.bosonit.backend.domain.entities.Game.Shot;
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
    @GeneratedValue
    @Column(name = "id_player")
    public int idPlayer;
    @Column(name = "num_player")
    public int numPlayer;
    @Column(name = "name")
    public String name;
    @Column(name = "password")
    public String password;
    @Column(name = "ip_address")
    public String ipAddress;

    //Un jugador puede tener varios tiros
    @OneToMany(mappedBy = "player",cascade = CascadeType.ALL)
    public List<Shot> shotList = new ArrayList<>();

    //Un jugador puede tener varias partidas (ganadas)
    @OneToMany(mappedBy = "player",cascade = CascadeType.ALL)
    public List<Game> gamesList = new ArrayList<>();

}
