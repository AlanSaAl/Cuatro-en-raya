import axios from 'axios'

export const createGame = (idPlayer) => {
    const response = axios({
        url: "/juego/crear",
        method: "POST",
        data: {idPlayer:idPlayer}
    })
    return response.then((res) => res.data.idGame)
}

export const joinGame = (idGame) => {
    const response = axios({
        url: ``,
        method: "PATCH",
        data: { idGame }
    })
    return response.then((res) => res.data)
}