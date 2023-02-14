import { useContext } from "react";
import Game from "./Game";
import Start from "./components/start";
import { GameContext } from "./context/GameContext";

function App() {
    const { screen } = useContext(GameContext); 

    return(
        <div className="App">
            <div className="container">
                {screen === "start" ? <Start /> : <Game />}
            </div>
        </div>
    );
}

export default App;