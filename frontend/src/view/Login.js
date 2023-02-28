import { useNavigate } from 'react-router-dom'
import FormPlayer from '../components/FormPlayer'
import { loginPlayer } from '../request/playerRequest'

export const Login = () => {
    const navigate = useNavigate()

    const handleSubmit = (values) => {
        loginPlayer(values.userName, values.userPassword)
            .then(() => navigate('/options'))
            .catch((res) => console.log(res))
    }

    return(
        <FormPlayer handleSubmit={ handleSubmit } formName={ 'Iniciar sesión' } />
    )
}