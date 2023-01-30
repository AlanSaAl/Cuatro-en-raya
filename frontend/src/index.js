import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';

import casillaVacia from './casilla-vacia.png';

/*
Función para crear una sola casilla.
Utiliza la imagen de casilla vacia, las otras imagenes aun no se usan.
Cuando se hace click sobre la casilla se manda un console.log() con el numero que le corresponde a la casilla.
*/
function Casilla(props) {
  return (
    <button
      className = "casilla"
      onClick={() => console.log(props.value)}
    >
      <img src = {casillaVacia}
      className = "casilla-vacia"
      style = {{width:"12vmin", height:"12vmin"}}
      />
    </button>
  );
}

/*
Clase para crear el tablero a partir de multiples casillas.
*/
class Tablero extends React.Component {
  renderCasilla(i) {
    return <Casilla value={i} />;
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

/*
Clase que despliega el tablero.
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
      </div>
    );
  }
}

const root = ReactDOM.createRoot(document.getElementById("root"));
root.render(<Game />);