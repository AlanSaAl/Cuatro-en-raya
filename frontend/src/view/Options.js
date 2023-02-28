import { useNavigate } from 'react-router-dom'
import { Button } from 'antd'
import { createGame } from '../request/gameRequest'

export const Options = () => {
    const navigate = useNavigate()

    const handleSubmit = async () => {
        var idPlayer = localStorage.getItem("idPlayer")
        var idGame = await createGame(idPlayer)
        navigate(`/game/${idGame}`)
    }

    return(
        <div className = 'options-buttons'>
            <Button className = 'optionBtn' onClick = { () => handleSubmit()}>Crear juego</Button>
            <Button className = 'optionBtn'>Unirse a un juego</Button>
            <Button className = 'optionBtn'>Historial de partidas</Button>
        </div>
    )
}