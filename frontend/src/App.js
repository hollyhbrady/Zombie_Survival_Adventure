import './App.css';

import React, {useState} from "react";
import { BrowserRouter as Router, Route, Switch } from "react-router-dom";
import NewPlayer from "./components/NewPlayer";
import Game from "./components/Game";

const App = () => {

  const [name, setName] = useState("");
  const [survivorLevel, setSurvivorLevel] = useState("");

  const updateName = (name) => {
    setName(name)
  } 

  const updateSurvivorLevel = (survivorLevel) => {
    setSurvivorLevel(survivorLevel)
  }

  return (
    <div className="Game-start">
      <h1>Zombie Survival Adventure</h1>
      <NewPlayer> name={name} updateName={updateName} survivorLevel={survivorLevel} updateSurvivorLevel={updateSurvivorLevel}
      </NewPlayer>
      <Game> name={name} survivorLevel={survivorLevel}
      </Game>
      {/* <Router>
      <Route exact path="/" component={NewPlayer} />
      <Route exact path="/game" component={Game} />
      </Router> */}
    </div>
  );
}

export default App;
