package com.bosonit.backend.application.services.game;

import com.bosonit.backend.Mappers.GameMapper;
import com.bosonit.backend.controllers.game.dtos.GameInput;
import com.bosonit.backend.controllers.game.dtos.GameOutput;
import com.bosonit.backend.domain.entities.Game.Game;
import com.bosonit.backend.repository.GameRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.stream.StreamSupport;

@Service
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class GameServiceImpl implements GameService{
    GameRepository gameRepository;

    private static final Logger log = LoggerFactory.getLogger(GameServiceImpl.class);

    @Override
    public GameOutput getGame(int idGame) {
        Game Game = gameRepository.findById(idGame).orElseThrow();
        GameOutput GameOutput = GameMapper.gMapper.gameToGameOutput(Game);
        log.info("Game obtenido: "+ GameOutput);
        return GameOutput;
    }

    @Override
    public Iterable<GameOutput> getAllGames(int pageNumber, int pageSize) {
        PageRequest pageRequest = PageRequest.of(pageNumber, pageSize);

        Iterable <Game> Gamees = gameRepository.findAll(pageRequest).getContent();
        Iterable<GameOutput> GameesOutput = StreamSupport.stream(Gamees.spliterator(),false)
                .map(Game -> GameMapper.gMapper.gameToGameOutput(Game)).toList();

        log.info("Gamees: "+GameesOutput);
        return GameesOutput;
    }


    @Override
    public void deleteGameById(int idGame) {
        Game game = gameRepository.findById(idGame).orElseThrow();
        gameRepository.deleteById(idGame);

        log.info("Game eliminado: "+ game);
    }
}
