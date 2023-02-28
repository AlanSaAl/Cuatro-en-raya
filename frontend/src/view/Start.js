import React from 'react'
import '../styles/start.css'
import { useNavigate } from 'react-router-dom'
import { Button, Form, Input } from 'antd'
import { UserOutlined } from '@ant-design/icons'

const Start = ({handleSubmit}) => {
    const navigate = useNavigate()
    
    return(
        <div className = "form-container">
            <div className = "form-title">
                <h1>Iniciar sesión</h1>
            </div>
            <div className = "form-input">
                <Form className = "form-user-data">
                    <Form.Item name = "username" rules = {[
                        {
                            required: true,
                            message: "Por favor escribe un nombre de usuario"
                        }
                    ]}>
                        <Input placeholder = "username" />
                    </Form.Item>
                    <Form.Item name = "password" rules = {[
                        {
                            required: true,
                            message: "Por favor escribe una contraseña"
                        }
                    ]}>
                        <Input placeholder = "password" />
                    </Form.Item>
                    <Form.Item>
                        <Button htmlType = "submit" className = "user-data-btn">Ingresar</Button>
                    </Form.Item>
                </Form>
            </div>
            <div className = "form-buttons">
                <button class = "button1" name = "registrarseBtn">Registrarse</button>
                <button class = "button1" name = "entrarBtn" onClick = { () => navigate("/options") }>Entrar</button>
            </div>
        </div>
    )
}

export default Start;