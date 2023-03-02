package com.bosonit.backend.application.services.game;

import com.bosonit.backend.Mappers.GameMapper;
import com.bosonit.backend.controllers.game.dtos.GameOutput;
import com.bosonit.backend.controllers.player.dtos.PlayerInput;
import com.bosonit.backend.domain.entities.Game.Game;
import com.bosonit.backend.domain.entities.Game.Shot;
import com.bosonit.backend.domain.entities.Player.Player;
import com.bosonit.backend.repository.GameRepository;
import com.bosonit.backend.repository.PlayerRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Slf4j
public class GameServiceImpl implements GameService {
    @Autowired
    private GameRepository gameRepository;
    @Autowired
    private PlayerRepository playerRepository;
    int MAX_PLAYERS = 2;

    @Override
    public GameOutput addGame(int player1Id) {
        //Get the player by id
        Player playerOne = playerRepository.findById(player1Id).orElseThrow(() -> new IllegalArgumentException("El jugador con id " + player1Id + " no existe"));
        //Create a new game and add it the player1
        Game newGame = new Game();
        newGame.addPlayer(playerOne);
        //Setting the player1 as a participant of the new game
        playerOne.addGame(newGame);
        gameRepository.save(newGame);
        playerRepository.save(playerOne);
        return GameMapper.gMapper.gameToGameOutput(newGame);
    }
    public GameOutput getGame(int idGame) {
        Game Game = gameRepository.findById(idGame).orElseThrow();
        GameOutput GameOutput = GameMapper.gMapper.gameToGameOutput(Game);
        log.info("Game obtenido: "+ GameOutput);
        return GameOutput;
    }

    public Pair<Player, Optional<Integer>> joinGame(int idGame, String playerName) throws Exception {
        log.info("Joining game {} with playerToJoin {}", idGame, playerName);
        Game game = gameRepository.findById(idGame).orElseThrow();
        List<Player> players =game.getPlayers();

        Player playerToJoin = playerRepository.findByUserName(playerName).orElseThrow();

        joinPlayer(idGame,playerToJoin);
        gameRepository.save(game);
        playerRepository.save(playerToJoin);

        Player startingPlayer = (players.size() == MAX_PLAYERS) ? players.get(0) : null;
        Optional<Integer> startingPlayerId = Optional.ofNullable(startingPlayer).map(Player::getIdPlayer);
        return Pair.of(playerToJoin, startingPlayerId);
    }

    public void setWinner(Game game, Player winner) {
        game.setWinner(!winner.equals(new Player()) ? winner : null);
        game.setFinished(true);
        gameRepository.save(game);
    }

    public void joinPlayer(int idGame ,Player player) throws Exception {

        Game currentGame = gameRepository.findById(idGame).orElseThrow();
        List<Player> players =currentGame.getPlayers();
        if (players.size() == MAX_PLAYERS) {
            throw new Exception("Max players reached");
        }
        if (players.contains(player)) {
            throw new Exception("The player is already in the game");
        }
        players.add(player);
        List<Game> playersGames = player.getGames();
        playersGames.add(currentGame);
        player.setGames(playersGames);
    }

    public Player checkWinner(int idGame) {
        Game currentGame = gameRepository.findById(idGame).orElseThrow();
        List<Shot> currentGameShots = currentGame.getShots();

        if (currentGameShots.size() == 42) {
            return new Player();
        }

        Player[][] board = new Player[6][7];
        for (Shot shot : currentGameShots) {
            board[shot.getRenglon()][shot.getCol()] = shot.getPlayer();
        }

        // Verificar filas
        // i = fila = 5
        // j = columna = 0
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 4; j++) {
                if (board[i][j] != null &&
                        board[i][j] == board[i][j + 1] &&
                        board[i][j] == board[i][j + 2] &&
                        board[i][j] == board[i][j + 3]) {
                    return board[i][j] ;
                }
            }
        }

        // Verificar columnas
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 7; j++) {
                if (board[i][j] != null &&
                        board[i][j] == board[i + 1][j] &&
                        board[i][j] == board[i + 2][j] &&
                        board[i][j] == board[i + 3][j]) {
                    return board[i][j];
                }
            }
        }

        // Verificar diagonales hacia la derecha
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                if (board[i][j] != null &&
                        board[i][j] == board[i + 1][j + 1] &&
                        board[i][j] == board[i + 2][j + 2] &&
                        board[i][j] == board[i + 3][j + 3]) {
                    return board[i][j];
                }
            }
        }

        // Verificar diagonales hacia la izquierda
        for (int i = 0; i < 3; i++) {
            for (int j = 6; j >= 3; j--) {
                if (board[i][j] != null &&
                        board[i][j] == board[i + 1][j - 1] &&
                        board[i][j] == board[i + 2][j - 2] &&
                        board[i][j] == board[i + 3][j - 3]) {
                    return board[i][j];
                }
            }
        }
        return null;
    }

    @Override
    public GameOutput getGame(String idGame) {
        return null;
    }



    @Override
    public Iterable<GameOutput> getAllGames(int pageNumber, int pageSize) {
        return null;
    }

    @Override
    public void deleteGameById(String idGame) {

    }

    @Override
    public GameOutput crearJuego(PlayerInput playerInput) {
        return null;
    }





















/*
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
    public void deleteGameById(String idGame) {
        Game game = gameRepository.findById(idGame).orElseThrow();
        gameRepository.deleteById(idGame);

        log.info("Game eliminado: "+ game);
    }

    // Corregir
    @Override
    public GameOutput crearJuego(PlayerInput playerInput) {
        Game game = new Game();
        gameRepository.save(game);
        return GameMapper.gMapper.gameToGameOutput(game);
    }

 */
}
