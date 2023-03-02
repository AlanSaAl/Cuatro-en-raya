package com.bosonit.backend.application.services.game;

import com.bosonit.backend.Mappers.GameMapper;
import com.bosonit.backend.controllers.game.dtos.GameOutput;
import com.bosonit.backend.controllers.player.dtos.PlayerInput;
import com.bosonit.backend.domain.entities.Game.Game;
import com.bosonit.backend.domain.entities.Player.Player;
import com.bosonit.backend.repository.GameRepository;
import com.bosonit.backend.repository.PlayerRepository;
import lombok.AllArgsConstructor;
import lombok.ToString;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;

@Service
@ToString
@AllArgsConstructor
public class GameServiceImpl implements GameService{

    private GameRepository gameRepository;

    private PlayerRepository playerRepository;

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
                .map(GameMapper.gMapper::gameToGameOutput).toList();

        log.info("Gamees: "+GameesOutput);
        return GameesOutput;
    }


    @Override
    public void deleteGameById(int idGame) {
        Game game = gameRepository.findById(idGame).orElseThrow();
        gameRepository.deleteById(idGame);

        log.info("Game eliminado: "+ game);
    }

    // Corregir
    @Override
    public GameOutput crearJuego(PlayerInput playerInput) {
        log.info("solicitud para crear juego: {}", playerInput);
        Game game = new Game();
        Player playerOne = playerRepository.findById(playerInput.getIdPlayer()).orElseThrow();

        game.setPlayers(List.of(playerOne));
        playerOne.setGames(List.of(game));

        return GameMapper.gMapper.gameToGameOutput(gameRepository.save(game));
    }

    @Override
    public Pair<Player, Optional<Integer>> joinGame(int idPlayer, int idGame) throws Exception{
        Game game = gameRepository.findById(idGame).orElseThrow();
        Player playerToJoin = playerRepository.findById(idPlayer).orElseThrow();

        game.setPlayerToGame(playerToJoin);
        gameRepository.save(game);
        playerRepository.save(playerToJoin);

        Player firstPlayer = game.getPlayers().get(0);
        Optional<Integer> firstPlayerId = Optional.ofNullable(firstPlayer).map(Player::getIdPlayer);

        return Pair.of(playerToJoin, firstPlayerId);
    }
}
