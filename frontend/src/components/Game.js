import { useEffect, useState } from "react"
import "../styles/game.css"
import { BoardRow } from "./BoardRow"

export const Game = () => {
    
    const [board, setBoard] = useState([])
    
    const initBoard = () => {
        var generatedBoard = []

        for (var r = 0; r < 6; r++) {
            var row = []
            for (var c = 0; c < 7; c++) {
                const movement = null
                if (movement === null) {
                    row.push(0)
                }
            }
            generatedBoard.push(row)
        }
        setBoard(generatedBoard )
    }

    useEffect(() => {
        const startGame = async () => {
            initBoard()
        } 
        startGame()
    }, [])

    return(
        <div>
            <h1>Nuevo componente Game</h1>
            <table>
                <tbody>
                    {board.map((row, i) => 
                        <BoardRow key={i} row={row}/>)}
                </tbody>
            </table>
            
        </div>
    )
}