import axios from 'axios'

export const createGame = (idPlayer) => {
    const response = axios({
        url: "/juego/crear",
        method: "POST",
        data: {idPlayer:idPlayer}
    })
    return response.then((res) => res.data.idGame)
}

export const joinGame = (idPlayer, idGame) => {
    const response = axios({
        url: '/juego/join',
        method: "PATCH",
        data: { idPlayer, idGame }
    })
    return response.then((res) => res.data)
}