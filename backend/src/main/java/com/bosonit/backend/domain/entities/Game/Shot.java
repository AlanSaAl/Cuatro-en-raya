package com.bosonit.backend.domain.entities.Game;

import com.bosonit.backend.domain.entities.Player.Player;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Shot {
    public Integer shotValue = null;
}
