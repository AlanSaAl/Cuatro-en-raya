import "../styles/game.css"
import casillaVacia from '../assets/casilla-vacia.png'
import fichaRoja from '../assets/ficha-roja.png'
import fichaAmarilla from '../assets/ficha-amarilla.png'

export const BoardCell = ({value}) => {
    var cellType = casillaVacia
    if (value === 1) {
        cellType = fichaRoja
    } else if (value === 2) {
        cellType = fichaAmarilla
    }

    return(
        <td>
            <div className = "cell">
                <img src = { cellType } style = {{width:"10vmin", height:"10vmin"}}/>
            </div>
        </td>   
    )
}