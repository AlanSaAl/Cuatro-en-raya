package com.bosonit.backend;


import com.bosonit.backend.domain.entities.Player.Player;
import com.bosonit.backend.repository.PlayerRepository;
import com.github.javafaker.Faker;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@AllArgsConstructor
public class BackendApplication implements CommandLineRunner {
	@Autowired
	Faker faker;
	@Autowired
	PlayerRepository playerRepository;


	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}

	@Override
	public void run(String... args){
		for(int i = 0; i < 10; i++) {
			Player player = new Player();
			player.setUserName(faker.name().username());
			player.setUserPassword(faker.internet().password());
			playerRepository.save(player);
		}
		Player playerStatic = Player.builder()
				.userName("user")
				.userPassword("1234")
				.build();
		playerRepository.save(playerStatic);

		Player playerStaticTwo = Player.builder()
				.userName("user2")
				.userPassword("1234")
				.build();
		playerRepository.save(playerStaticTwo);
	}
}
