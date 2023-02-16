import { useNavigate } from "react-router-dom"

const Options = () => {
    const navigate = useNavigate()
    
    return(
        <div className = "options-buttons">
            <Button onClick = { () => useNavigate("/game") }>Crear juego</Button>
            <Button onClick = { () => useNavigate() }>Unirse a un juego</Button>
            <Button onClick = { () => useNavigate() }>Historial de partidas</Button>
        </div>
    )
}

export default Options