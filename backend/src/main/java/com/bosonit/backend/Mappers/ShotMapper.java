package com.bosonit.backend.Mappers;

import com.bosonit.backend.controllers.game.dtos.ShotInput;
import com.bosonit.backend.controllers.game.dtos.ShotOutput;
import com.bosonit.backend.domain.entities.Game.Shot;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(uses={PlayerMapper.class,GameMapper.class})
public interface ShotMapper {
    ShotMapper sMapper = Mappers.getMapper(ShotMapper.class);

    Shot shotInputToShot(ShotInput shotInput);
    ShotOutput shotToShotOutput(Shot shot);
}
