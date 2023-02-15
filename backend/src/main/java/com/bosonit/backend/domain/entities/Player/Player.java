package com.bosonit.backend.domain.entities.Player;

import lombok.*;
import javax.persistence.*;

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
    @Column(name = "id_player")
    public int idPlayer;

    @Column(name = "user_name")
    public String userName;

    @Column(name = "user_password")
    public String userPassword;
}
