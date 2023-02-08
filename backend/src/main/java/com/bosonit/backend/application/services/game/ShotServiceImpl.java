package com.bosonit.backend.application.services.game;

import com.bosonit.backend.controllers.game.dtos.ShotOutput;
import com.bosonit.backend.controllers.player.dtos.PlayerInput;
import com.bosonit.backend.domain.entities.Game.Game;
import com.bosonit.backend.domain.entities.Game.Shot;
import com.bosonit.backend.domain.entities.Player.Player;
import com.bosonit.backend.repository.GameRepository;
import com.bosonit.backend.repository.PlayerRepository;
import com.bosonit.backend.repository.ShotRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShotServiceImpl implements ShotService{
    @Autowired
    ShotRepository shotRepository;
    @Autowired
    PlayerRepository playerRepository;
    @Autowired
    GameRepository gameRepository;

    Logger logger = LoggerFactory.getLogger(ShotServiceImpl.class);
    public Integer [][] matrixShotValue = {{0,0,0},
                              {0,0,0},
                              {0,0,0}
    };

    public Integer [][] matrixIdShot = {{1,2,3},
                                    {4,5,6},
                                    {7,8,9}
    };

    public void playerShot(Integer x, Integer y, Integer idGame,Integer idPlayer,Integer numPlayer){
        Integer [][] mSV = this.matrixShotValue;
        Integer [][] mIdS = this.matrixIdShot;
        Boolean checkShot = (mSV[x][y]==0);
        Boolean winner = false;
        int pValueShot = (numPlayer==1)?1:2;

        int pValueIdShot = mIdS[x][y];

        Player player = playerRepository.findById(idPlayer).orElseThrow();
        Game game = gameRepository.findById(idGame).orElseThrow();

        if(checkShot){
            //Asigna en la matriz GATO el tiro con valor X en la posición x,y
            mSV[x][y]=pValueShot;

            //Obten de la tabla de tiros, el renglón en la posición pValueIdShot
            Shot shotValue = shotRepository.findById(pValueIdShot).orElseThrow();

            //Asigna en el renglón pValueIdShot el valor de pValueShot
            shotValue.setShotValue(pValueShot);

            //Revisa si hay un ganador
            winner=checkGame(mSV,pValueShot);

            shotRepository.save(shotValue);

            logger.info(player.toString());
            logger.info(game.toString());
        }else{
            System.out.println("Tiro incorrecto");
        }

        if(winner){
            player.getGamesList().add(game);
            System.out.println("\n============>El jugador número: "+numPlayer+" ha ganado\n");
        }

    }


    public boolean checkGame(Integer [][] gameMatrix,Integer pValueShot){
        int rowSize = 3, colSize = 3;

       //Verifica los renglones
        for (int i = 0; i < rowSize; i++) {
            int count = 0;
            for (int j = 0; j < colSize; j++) {
                if (gameMatrix[i][j].equals(pValueShot)) {
                    count++;
                }
            }
            if (count == rowSize) {
                return true;
            }
        }

        // Verifica las columnas
        for (int i = 0; i < colSize; i++) {
            int count = 0;
            for (int j = 0; j < rowSize; j++) {
                if (gameMatrix[j][i].equals(pValueShot)) {
                    count++;
                }
            }
            if (count == colSize) {
                return true;
            }
        }

        // Verifica las diagonales
        int count = 0;
        for (int i = 0; i < rowSize; i++) {
            if (gameMatrix[i][i].equals(pValueShot)) {
                count++;
            }
        }
        if (count == rowSize) {
            return true;
        }

        count = 0;
        for (int i = 0; i < rowSize; i++) {
            if (gameMatrix[i][rowSize - i - 1].equals(pValueShot)) {
                count++;
            }
        }
        if (count == rowSize) {
            return true;
        }

        return false;
    }

}
