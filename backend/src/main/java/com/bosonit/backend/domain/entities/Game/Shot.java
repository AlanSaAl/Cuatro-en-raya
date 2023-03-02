package com.bosonit.backend.domain.entities.Game;

import com.bosonit.backend.domain.entities.Player.Player;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name="shot")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Shot {
    @Id
    @GeneratedValue
    private long id;

    @ManyToOne
    private Player player;

    @ManyToOne
    private Game game;

    private int renglon;

    private int col;
}
