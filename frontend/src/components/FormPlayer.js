import '../styles/start.css'
import { Button, Form, Input } from 'antd'
import { UserOutlined, LockFilled } from '@ant-design/icons'

const FormPlayer = ({ handleSubmit, formName }) => {
    return(
        <div className = 'form-container'>
            <div className = 'form-title'>
                <h1>{ formName }</h1>
            </div>
            <div className = 'form-input'>
                <Form className = 'form-user-data' onFinish={ handleSubmit }>
                    <Form.Item name = 'userName' rules = {[
                        {
                            required: true,
                            message: 'Por favor escribe un nombre de usuario'
                        }
                    ]}>
                        <Input placeholder = 'username' />
                    </Form.Item>
                    <Form.Item name = 'userPassword' rules = {[
                        {
                            required: true,
                            message: 'Por favor escribe una contraseña'
                        }
                    ]}>
                        <Input.Password placeholder = 'password' />
                    </Form.Item>
                    <Form.Item>
                        <Button htmlType = 'submit' className = 'user-data-btn'>Ingresar</Button>
                    </Form.Item>
                </Form>
            </div>
        </div>
    )
}

export default FormPlayer