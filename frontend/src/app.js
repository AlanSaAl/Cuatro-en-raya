import { BrowserRouter, Route, Routes, useNavigate } from 'react-router-dom'
import Game from './components/Game'
import Start from './view/Start'

function App() {
    return(
        <BrowserRouter>
                <Routes>
                    <Route path = "/">
                        <Route index element = {<Start />}/>
                    </Route>
                    <Route path = "/game">
                        <Route index element = {<Game />}/>
                    </Route>
                </Routes>
        </BrowserRouter>
    );
}

export default App;