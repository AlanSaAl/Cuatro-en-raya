import { useNavigate } from "react-router-dom"

const Options = () => {
    const navigate = useNavigate()
    
    return(
        <div className = "options-buttons">
            <button name = "create-game-btn" onClick = { () => navigate("/game") }>Crear juego</button>
            <button>Unirse a un juego</button>
            <button>Historial de partidas</button>
        </div>
    )
}

export default Options