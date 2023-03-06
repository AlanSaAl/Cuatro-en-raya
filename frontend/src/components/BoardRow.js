import { BoardCell } from "./BoardCell"

export const BoardRow = ({ row }) => {
    return(
        <tr>
            {row.map((cell, i) => <BoardCell key = {i} value = {cell} columnIndex = {i} />)}
        </tr>
    )
}