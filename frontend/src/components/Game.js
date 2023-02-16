import React from 'react';
import axios from 'axios';
import '../style.css';
import casillaVacia from '../assets/casilla-vacia.png';
import fichaRoja from '../assets/ficha-roja.png';
import fichaAmarilla from '../assets/ficha-amarilla.png';

/**
 * Función para crear una sola casilla.
 * Dependiendo de a que sea igual value se pinta una imagen u otra.
 */
function Casilla(props) {
  return (
    <button
      className = "casilla"
      onClick={props.onClick}
    >
      {props.value === null && <img src = {casillaVacia} style = {{width:"10vmin", height:"10vmin"}} />}
      {props.value === 'R' && <img src = {fichaRoja} style = {{width:"10vmin", height:"10vmin"}} />}
      {props.value === 'A' && <img src = {fichaAmarilla} style = {{width:"10vmin", height:"10vmin"}} />}
    </button>
  );
}

/**
 * Clase para crear el tablero a partir de multiples casillas.
 * Siempre se comienza por las fichas rojas, con cada click se alterna entre fichas.
 */
class Tablero extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      casillas: Array(42).fill(null),
      rIsNext: true,
    };
  }

  handleClick(i) {
    const casillas = this.state.casillas.slice();
    casillas[i] = this.state.rIsNext ? 'R' : 'A';
    this.setState({
      casillas: casillas,
      rIsNext: !this.state.rIsNext,
    });
  }

  renderCasilla(i) {
    return (
      <Casilla
        value = {this.state.casillas[i]}
        onClick = {() => this.handleClick(i)}
      />
    );
  }

  render() {
    const status = 'Cuatro en raya';

    return (
      <div>
        <div className = "status">{status}</div>
        <div className = "tablero-fila">
          {this.renderCasilla(0)}
          {this.renderCasilla(1)}
          {this.renderCasilla(2)}
          {this.renderCasilla(3)}
          {this.renderCasilla(4)}
          {this.renderCasilla(5)}
          {this.renderCasilla(6)}
        </div>

        <div className = "tablero-fila">
          {this.renderCasilla(7)}
          {this.renderCasilla(8)}
          {this.renderCasilla(9)}
          {this.renderCasilla(10)}
          {this.renderCasilla(11)}
          {this.renderCasilla(12)}
          {this.renderCasilla(13)}
        </div>

        <div className = "tablero-fila">
          {this.renderCasilla(14)}
          {this.renderCasilla(15)}
          {this.renderCasilla(16)}
          {this.renderCasilla(17)}
          {this.renderCasilla(18)}
          {this.renderCasilla(19)}
          {this.renderCasilla(20)}
        </div>

        <div className = "tablero-fila">
          {this.renderCasilla(21)}
          {this.renderCasilla(22)}
          {this.renderCasilla(23)}
          {this.renderCasilla(24)}
          {this.renderCasilla(25)}
          {this.renderCasilla(26)}
          {this.renderCasilla(27)}
        </div>

        <div className = "tablero-fila">
          {this.renderCasilla(28)}
          {this.renderCasilla(29)}
          {this.renderCasilla(30)}
          {this.renderCasilla(31)}
          {this.renderCasilla(32)}
          {this.renderCasilla(33)}
          {this.renderCasilla(34)}
        </div>

        <div className = "tablero-fila">
          {this.renderCasilla(35)}
          {this.renderCasilla(36)}
          {this.renderCasilla(37)}
          {this.renderCasilla(38)}
          {this.renderCasilla(39)}
          {this.renderCasilla(40)}
          {this.renderCasilla(41)}
        </div>
      </div>
    );
  }
}

/**
 * Manda los datos iniciales al backend para guardarlos en BD.
 */
function create_game() {
    let nombre = document.getElementById("nombre").value;
    if (nombre == null || nombre === '') {
        alert("Por favor escribe un nombre de jugador");
    } else {
        axios.post("http://localhost:8080/juego/crear", {
          name: nombre,
          password: '1234'
        })
        .catch(function(error) {
          console.log(error);
        })
    }
}

/**
 * Clase que despliega el tablero.
 */
class Game extends React.Component {
  render() {
    return (
      <div className = "game">
        <div className = "tablero">
          <Tablero />
        </div>
        <div className = "game-info">
          <div>{/* status */}</div>
          <ol>{/* todo */}</ol>
        </div>
        <div className = "nombre-jugador">
          <input id="nombre" placeholder="Nombre del jugador"></input>
          <button name="crearJuegoNuevoBtn" onClick = {() => create_game()}>Crear juego nuevo</button>
        </div>
      </div>
    );
  }
}

export default Game;