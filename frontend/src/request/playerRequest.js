import axios from 'axios'
import { checkStatus } from './statusChecker'

export async function createPlayer(userName, userPassword) {
    await axios({
        url: "/api/signup",
        method: "POST",
        data: {userName, userPassword}
    }).then(checkStatus)
}

export async function loginPlayer(userName, userPassword) {
    await axios({
        url: "/api/login",
        method: "POST",
        data: {userName, userPassword}
    }).then(checkStatus)
        .then((res) => {
            localStorage.setItem("idPlayer", res.data.idPlayer)
            localStorage.setItem("userName", res.data.userName)
        })
}