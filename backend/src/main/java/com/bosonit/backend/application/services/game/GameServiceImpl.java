package com.bosonit.backend.application.services.game;

import lombok.ToString;
import org.springframework.stereotype.Service;

@Service
@ToString
public class GameServiceImpl {

    public int [][] matriz = {{0,0,0},
            {0,0,0},
            {0,0,0}
    };

    public void tiroJugadorUno(int x,int y){

        matriz[x][y] = 1;
    }

    public void tiroJugadorDos(int x,int y){

        matriz[x][y] = 2;
    }

    public boolean revisarTablero(int [][] matriz){
        if(matriz[0][0]==1 && matriz[0][1]==1 && matriz[0][2]==1){
            return true;
        }else{
            return false;
        }
    }
}
