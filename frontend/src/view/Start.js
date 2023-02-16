import React from 'react'
import { useNavigate } from "react-router-dom"

const Start = () => {
    const navigate = useNavigate()
    
    return(
        <div className = "form-register-container">
            <div className = "form-register_title">
                <h1>Iniciar sesión</h1>
            </div>
            <div className = "form-register_input">
                <form>
                    <label htmlFor = "user">Usuario</label>
                    <input id="user"></input><br></br>
                    <label htmlFor = "password">Contraseña</label>
                    <input id = "password"></input>
                </form>
            </div>
            <div className = "form-register_buttons">
                <button class = "button1" name = "registrarseBtn">Registrarse</button>
                <button class = "button1" name = "entrarBtn" onClick = { () => navigate("/game") }>Entrar</button>
            </div>
        </div>
    )
}

export default Start;