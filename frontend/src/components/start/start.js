import { useContext } from "react";
import { GameContext } from "../../context/GameContext";

const Start = () => {
    const { handleStart } = useContext(GameContext);

    return (
        <div className = "start">
            <div className = "start_header">
                <h1>Iniciar sesión</h1>
            </div>
            <div className = "start_input">
                <form>
                    <label htmlFor = "user">Usuario</label>
                    <input id="user"></input><br></br>
                    <label htmlFor = "password">Contraseña</label>
                    <input id = "password"></input>
                </form>
            </div>
            <div className = "start_buttons">
                <button class = "button1" name = "registrarseBtn">Registrarse</button>
                <button class = "button1" name = "entrarBtn" onClick={() => handleStart("cpu")}>Entrar</button>
            </div>
        </div>
    );
};

export default Start;