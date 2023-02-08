package com.bosonit.backend.Mappers;

import com.bosonit.backend.controllers.player.dtos.PlayerInput;
import com.bosonit.backend.controllers.player.dtos.PlayerOutput;
import com.bosonit.backend.domain.entities.Player.Player;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
@Mapper(uses= {})
public interface PlayerMapper {
    PlayerMapper jMapper = Mappers.getMapper(PlayerMapper.class);

    Player jugadorInputToJugador(PlayerInput playerInput);
    PlayerOutput jugadorToJugadorOutput(Player player);
}
