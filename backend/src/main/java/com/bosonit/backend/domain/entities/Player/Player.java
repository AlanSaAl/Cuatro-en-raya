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
    @Column(name = "user")
    public String user;
    @Column(name = "password")
    public String password;
}
