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
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@AllArgsConstructor
public class GameServiceImpl implements GameService {

    private GameRepository gameRepository;

    private PlayerRepository playerRepository;

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

    @Override
    public GameOutput getGame(int idGame) {
        Game Game = gameRepository.findById(idGame).orElseThrow();
        GameOutput GameOutput = GameMapper.gMapper.gameToGameOutput(Game);
        log.info("Game obtenido: "+ GameOutput);
        return GameOutput;
    }

    public Player checkWinner(int idGame) {
        //Buscamos el juego por su id
        Game currentGame = gameRepository.findById(idGame).orElseThrow();
        //Obtenemos los tiros de ese juego
        List<Shot> currentGameShots = currentGame.getShots();

        //Si no el tamaño es 42 quiere decir que no hay ganador
        if (currentGameShots.size() == 42) {
            return new Player();
        }

        //Creamos una matriz de 6x7, cada posición de la matriz contiene a un jugador, después un algoritmo
        //revisa las combinaciones usando a los jugadores
        Player[][] board = new Player[6][7];

        //Para cada movimiento de la lista currentGameShots, obten las coordenadas del tiro (renglón y columna), después en esa posición
        //agrega al jugador que realizó el movimiento
        for (Shot shot : currentGameShots) {
            board[shot.getRenglon()][shot.getCol()] = shot.getPlayer();
        }


        //Se revisan las combinaciones, si coincide el mismo jugador 4 veces seguidas
        //Se regresa el tablero en la posición[i][j], es decir, el jugador que ganó el juego o null en caso de que no haya ganador

        // Verificar filas
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 4; j++) {
                if (    board[i][j] != null &&
                        board[i][j] == board[i][j + 1] &&
                        board[i][j] == board[i][j + 2] &&
                        board[i][j] == board[i][j + 3])
                {
                    return board[i][j];
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

    public void setWinner(Game game, Player winner) {
        game.setWinner(!winner.equals(new Player()) ? winner : null);
        game.setFinished(true);
        gameRepository.save(game);
    }

    @Override
    public Pair<Player, Optional<Integer>> joinGame(int idPlayer, int idGame) throws Exception {
        Game game = gameRepository.findById(idGame).orElseThrow();
        Player playerToJoin = playerRepository.findById(idPlayer).orElseThrow();

        game.setPlayerToGame(playerToJoin);
        gameRepository.save(game);
        playerRepository.save(playerToJoin);

        Player firstPlayer = game.getPlayers().get(0);
        Optional<Integer> firstPlayerId = Optional.ofNullable(firstPlayer).map(Player::getIdPlayer);

        return Pair.of(playerToJoin, firstPlayerId);
    }

    @Override
    public Iterable<GameOutput> getAllGames(int pageNumber, int pageSize) {
        return null;
    }
    @Override
    public void deleteGameById(String idGame) {}
    @Override
    public GameOutput crearJuego(PlayerInput playerInput) {
        return null;
    }

}
