import { BrowserRouter, Route, Routes, useNavigate } from 'react-router-dom'
import Game from './components/Game'
import Start from './view/Start'
import Options from './view/Options';

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
                    <Route path = "/options">
                        <Route index element = {<Options />}/>
                    </Route>
                </Routes>
        </BrowserRouter>
    );
}

export default App;