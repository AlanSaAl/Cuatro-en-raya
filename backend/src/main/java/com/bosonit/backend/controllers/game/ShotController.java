package com.bosonit.backend.controllers.game;

import com.bosonit.backend.application.services.game.ShotService;
import com.bosonit.backend.application.services.game.ShotServiceImpl;
import com.bosonit.backend.controllers.game.dtos.ShotInput;
import com.bosonit.backend.controllers.player.dtos.PlayerInput;
import com.bosonit.backend.controllers.player.dtos.PlayerOutput;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.Map;

@RestController
@RequestMapping("/shot")
public class ShotController {
    @Autowired
    ShotServiceImpl shotService;

    @PostMapping("/game/{idGame}/player/{idPlayer}/{numPlayer}")
    public ResponseEntity<?> addShot(@PathVariable Map<String, String> pathVarsMap,
                                     @RequestBody ShotInput shotInput) throws Exception{
        Integer idGame = Integer.parseInt(pathVarsMap.get("idGame"));
        Integer idPlayer = Integer.parseInt(pathVarsMap.get("idPlayer"));
        Integer numPlayer = Integer.parseInt(pathVarsMap.get("numPlayer"));
        int x = shotInput.getXShot();
        int y = shotInput.getYShot();
        shotService.playerShot(x,y,idGame,idPlayer,numPlayer);

        return ResponseEntity.status(HttpStatus.CREATED).body("Tiro realizado en la posición");
    }

}
