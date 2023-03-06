import { BrowserRouter, Route, Routes, useNavigate } from 'react-router-dom'
import { Game } from './components/Game'
import { Register } from './view/Register'
import { Login } from './view/Login'
import { Options } from './view/Options'
import { JoinGame } from './view/JoinGame'

function App() {
    return(
        <BrowserRouter>
                <Routes>
                    <Route path = '/'>
                        <Route index element = {<Register />}/>
                    </Route>
                    <Route path = '/login'>
                        <Route index element = {<Login />}/>
                    </Route>
                    <Route path = '/options'>
                        <Route index element = {<Options />}/>
                    </Route>
                    <Route path = '/joingame'>
                        <Route index element = {<JoinGame />}/>
                    </Route>
                    <Route path = '/game/:idGame'>
                        <Route index element = {<Game />}/>
                    </Route>
                </Routes>
        </BrowserRouter>
    )
}

export default App;