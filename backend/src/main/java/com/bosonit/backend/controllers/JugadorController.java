package com.bosonit.backend.controllers;


import com.bosonit.backend.application.services.JugadorService;
import com.bosonit.backend.dtos.JugadorInput;
import com.bosonit.backend.dtos.JugadorOutput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/jugador")
public class JugadorController {
    @Autowired
    JugadorService jugadorService;

    @PostMapping
    public ResponseEntity<JugadorOutput> addCliente(@RequestBody JugadorInput jugadorInput) throws Exception{
        JugadorOutput jugadorOutput= jugadorService.addJugador(jugadorInput);
        return ResponseEntity.status(HttpStatus.CREATED).body(jugadorOutput);
    }

    @GetMapping("/jugadores")
    public ResponseEntity<Iterable<JugadorOutput>>getAllJugadores(@RequestParam(defaultValue = "0", required = false) int pageNumber,
                                                  @RequestParam(defaultValue = "4", required = false) int pageSize) {
        Iterable<JugadorOutput>  jugadoresOutput = jugadorService.getAllJugadores(pageNumber,pageSize);
        return ResponseEntity.status(HttpStatus.OK).body(jugadoresOutput);
    }

    @GetMapping("/id/{idJugador}")
    public ResponseEntity<JugadorOutput> getJugadorById(@PathVariable int idJugador)
    {
        JugadorOutput jugadorOutput = jugadorService.getJugador(idJugador);
        return ResponseEntity.status(HttpStatus.OK).body(jugadorOutput);
    }


    @PutMapping("/update/{idJugador}")
    public ResponseEntity<JugadorOutput> updateJugador(@RequestBody JugadorInput jugadorInput,
                                                       @PathVariable int idJugador) {
        JugadorOutput jugadorOutput = jugadorService.updateJugador(idJugador,jugadorInput);
        return ResponseEntity.status(HttpStatus.OK).body(jugadorOutput);
    }

    @DeleteMapping("delete/{idJugador}")
    public ResponseEntity<JugadorOutput> deleteJugador(@PathVariable int idJugador) {
        JugadorOutput jugadorOutput = jugadorService.getJugador(idJugador);
        jugadorService.deleteJugadorById(idJugador);
        return ResponseEntity.status(HttpStatus.OK).body(jugadorOutput);
    }

}
