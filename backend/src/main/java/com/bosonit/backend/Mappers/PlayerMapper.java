package com.bosonit.backend.Mappers;

import com.bosonit.backend.controllers.player.dtos.PlayerInput;
import com.bosonit.backend.controllers.player.dtos.PlayerOutput;
import com.bosonit.backend.domain.entities.Player.Player;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper()
public interface PlayerMapper {
    PlayerMapper pMapper = Mappers.getMapper(PlayerMapper.class);

    Player playerInputToPlayer(PlayerInput playerInput);
    PlayerOutput playerToPlayerOutput(Player player);
}
