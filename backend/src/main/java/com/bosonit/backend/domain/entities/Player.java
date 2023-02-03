package com.bosonit.backend.domain.entities;

import lombok.*;
import javax.persistence.*;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Player {
    @Id
    @GeneratedValue
    private int idPlayer;
    private String name;
    private String password;

}
