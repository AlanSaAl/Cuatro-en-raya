package com.bosonit.backend;

import com.bosonit.backend.domain.entities.Game.Game;
import com.bosonit.backend.domain.entities.Game.Shot;
import com.bosonit.backend.domain.entities.Player.Player;
import com.bosonit.backend.repository.GameRepository;
import com.bosonit.backend.repository.PlayerRepository;
import com.bosonit.backend.repository.ShotRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
@AllArgsConstructor
public class BackendApplication implements CommandLineRunner {

	ShotRepository shotRepository;
	GameRepository gameRepository;
	PlayerRepository playerRepository;
	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {


		List<Shot> defaultShots = Arrays.asList(new Shot(),new Shot(),new Shot(),new Shot(),new Shot(),new Shot(),new Shot(),new Shot(),new Shot());
		Game defaultGame = new Game();
		List<Player> defaultPlayers =  Arrays.asList(new Player(),new Player());


		gameRepository.save(defaultGame);

		//defaultShots.get(0).setShotValue(1);defaultShots.get(1).setShotValue(1);

		for(int i =0; i<defaultShots.size();i++){
			shotRepository.save(defaultShots.get(i));
		}

		for(int i =0; i<defaultPlayers.size();i++){
			defaultPlayers.get(i).setName("Player no: "+i);
			defaultPlayers.get(i).setNumPlayer(i+1);
			playerRepository.save(defaultPlayers.get(i));
		}
	}
}
