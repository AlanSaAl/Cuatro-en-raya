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
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_game")
    public int idGame;

    @OneToOne
    @JoinColumn(name="id_match")
    Match match;
}
