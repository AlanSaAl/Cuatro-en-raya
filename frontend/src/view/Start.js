import React from 'react'
import { useNavigate } from "react-router-dom"
import { Button, Form, Input } from "antd"

const Start = () => {
    const navigate = useNavigate()
    
    return(
        <div className = "form-register-container">

            <Form>
                <Form.Item name = "username" >

                </Form.Item>
            </Form>

            <div className = "form-register_title">
                <h1>Iniciar sesión</h1>
            </div>
            <div className = "form-register_input">
                <form>
                    <label htmlFor = "user">Usuario</label>
                    <input id="user"></input><br></br>
                    <label htmlFor = "password">Contraseña</label>
                    <input id = "password"></input>
                    <input type = "submit"></input>
                </form>
            </div>
            <div className = "form-register_buttons">
                <button class = "button1" name = "registrarseBtn">Registrarse</button>
                <button class = "button1" name = "entrarBtn" onClick = { () => navigate("/options") }>Entrar</button>
            </div>
        </div>
    )
}

export default Start;