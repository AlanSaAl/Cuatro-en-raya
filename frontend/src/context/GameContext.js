import { createContext, useState, useContext } from "react";

const GameContext = createContext();

const GameState = (props) => {
    const [screen, setScreen] = useState("start");

    const handleStart = () => {
        setScreen("game");
    };

    return (
        <GameContext.Provider
            value = {{
                screen,
                handleStart
            }}
        >
            {props.children}
        </GameContext.Provider>
    );
};

export { GameContext, GameState };