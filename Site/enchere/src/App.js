import './App.css';
import { BrowserRouter as Router, Switch, Route} from 'react-router-dom';
import LoginUtilisateur from './components/LoginUtilisateur';
import InscriptionUtilisateur from './components/InscriptionUtilisateur';
import 'bootstrap/dist/css/bootstrap.min.css';
import ListEnchere from './components/ListEnchere';
import Header from './components/Header';

function App() {
  return(
    <div>
      <Router>
        <Header />
        <div className="container">
          <Switch>
            <Route exact path="/" component={ListEnchere}></Route>
            <Route path="/login" component={LoginUtilisateur}></Route>
            <Route path="/inscription" component={InscriptionUtilisateur}></Route>
          </Switch>
        </div>
      </Router>
    </div>
  )
}

export default App;