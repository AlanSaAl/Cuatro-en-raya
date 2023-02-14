import React from "react";
import ReactDOM from "react-dom/client";
import "./style.css";
import App from "./app";

import { GameState } from "./context/GameContext";

const root = ReactDOM.createRoot(document.getElementById("root"));

root.render(
    <React.StrictMode>
        <GameState>
            <App />
        </GameState>
    </React.StrictMode>
);