import { useNavigate } from 'react-router-dom'
import FormPlayer from '../components/FormPlayer'
import { createPlayer } from '../request/playerRequest'

export const Register = () => {
    const navigate = useNavigate()

    const handleSubmit = (values) => {
        createPlayer(values.userName, values.userPassword)  
            .then(() => navigate('/login'))
            .catch((res) => console.log(res))
    }

    return(
        <FormPlayer handleSubmit={ handleSubmit } formName={ 'Registrarse' } />
    )
} 