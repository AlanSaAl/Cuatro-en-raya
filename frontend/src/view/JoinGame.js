import '../styles/forms.css'
import { Form, Button, Card, Input } from 'antd'
import { useNavigate } from 'react-router-dom'
import { joinGame } from '../request/gameRequest'

export const JoinGame = () => {

    const navigate = useNavigate()

    const handleJoinGame = (values) => {
        joinGame(values.idGame)
            .then(() => navigate(`/game/${values.idGame}`))
            .catch((error) => console.log(error))
    }

    return(
        <div className = "join-game">
            <h1>Join Game</h1>
            <Form className = "form-join-game">
                <Form.Item>
                    <Input placeholder = "Escribe el id del juego" />
                </Form.Item>
                <Form.Item>
                    <Button htmlType = "submit">Unirse</Button>
                </Form.Item>
            </Form>
        </div>
    )
} 