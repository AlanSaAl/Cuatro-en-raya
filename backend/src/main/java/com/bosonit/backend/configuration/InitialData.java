package com.bosonit.backend.configuration;

import com.bosonit.backend.application.services.game.GameService;
import com.bosonit.backend.application.services.game.GameServiceImpl;
import com.bosonit.backend.domain.entities.Game.Game;
import com.bosonit.backend.domain.entities.Game.Shot;
import com.bosonit.backend.domain.entities.Player.Player;
import com.bosonit.backend.repository.GameRepository;
import com.bosonit.backend.repository.PlayerRepository;
import com.bosonit.backend.repository.ShotRepository;
import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InitialData {
    @Autowired
    Faker faker;
    @Autowired
    PlayerRepository playerRepository;
    @Autowired
    GameRepository gameRepository;
    @Autowired
    ShotRepository shotRepository;

    @Autowired
    GameServiceImpl gameService;
    public void createInitialData(){
        for(int i = 0; i < 10; i++) {
            Player player = new Player();
            player.setUserName(faker.name().username());
            player.setUserPassword(faker.internet().password());
            Game newGame = new Game();
            newGame.addPlayer(player);
            player.addGame(newGame);
            gameRepository.save(newGame);
            playerRepository.save(player);
        }

        Game firstGame = gameRepository.findAll().get(0);
        Player firstPlayer = playerRepository.findAll().get(0);
        Player secondPlayer = playerRepository.findAll().get(1);

        /*
        {0,0,0,0,0,0,0}
        {0,0,0,0,0,0,0}
        {0,0,0,0,0,0,0}
        {0,0,0,0,0,0,0}
        {0,0,0,0,0,0,0}
        {A,A,A,A,0,0,0}
        */

        List<Shot> shotsPlayerOne = Arrays.asList(
                Shot.builder().col(0).renglon(0).game(firstGame).player(firstPlayer).build(),
                Shot.builder().col(1).renglon(0).game(firstGame).player(firstPlayer).build(),
                Shot.builder().col(2).renglon(0).game(firstGame).player(firstPlayer).build(),
                Shot.builder().col(3).renglon(0).game(firstGame).player(firstPlayer).build()
        );

        List<Shot> shotsPlayerTwo = Arrays.asList(
                Shot.builder().col(1).renglon(1).game(firstGame).player(secondPlayer).build(),
                Shot.builder().col(2).renglon(1).game(firstGame).player(secondPlayer).build(),
                Shot.builder().col(3).renglon(1).game(firstGame).player(secondPlayer).build(),
                Shot.builder().col(4).renglon(1).game(firstGame).player(secondPlayer).build()
        );

        for(int i=0; i<=shotsPlayerOne.size()-1; i++){
            shotRepository.save(shotsPlayerOne.get(i));
            shotRepository.save(shotsPlayerTwo.get(i));
        }

        Player winner = gameService.checkWinner(1);
        System.out.println("El ganador es: " + winner.getUserName());

    }
}
