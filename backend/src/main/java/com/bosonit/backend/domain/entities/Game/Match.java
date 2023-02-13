package com.bosonit.backend.domain.entities.Game;


import lombok.*;

import javax.persistence.*;

@Entity
@Table(name="game")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Match {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_match")
    private int idMatch;

    @Column(name = "id_game")
    private int idGame;

    @Column(name = "id_player_one")
    private int idPlayerOne;

    @Column(name = "id_player_two")
    private int idPlayerTwo;

    @Column(name = "id_winner")
    private int idWinner;


}
