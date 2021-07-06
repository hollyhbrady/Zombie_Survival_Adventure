import './App.css';

import React, {useEffect, useState} from "react";
import { BrowserRouter as Router, Route, Switch } from "react-router-dom";
import NewPlayer from "./components/NewPlayer";
import Game from "./components/Game";
import Zombies from "./components/Zombies";
import Request from './helpers/Request';
import CORS from 'react';

const App = () => {

  const [name, setName] = useState("");
  const [survivorLevel, setSurvivorLevel] = useState("");
  const [zombies, setZombies] = useState([])

  const updateName = (name) => {
    setName(name)
  } 

  const updateSurvivorLevel = (survivorLevel) => {
    setSurvivorLevel(survivorLevel)
  }

  const requestAll = function() {
    const request = new Request();
    const zombiePromise = request.get('http://localhost:8080/zombies')
    const survivorLevelPromise = request.get('http://localhost:8080/survivorLevels')
    // .then((data) => {setZombies(data)})
    Promise.all([zombiePromise, survivorLevelPromise])
    .then((data) => {
      setZombies(data[0]);
      setSurvivorLevel(data[1])
    })
  }

  useEffect(() => {
    requestAll()
  }, [])

  console.log(zombies)

  const handlePost = function(survivor){
    const request = new Request();
    request.post("/api/survivors", survivor)
    .then(() => window.location = '/survivors')
  }


  return (
    <div className="Game-start">
      <h1>Zombie Survival Adventure</h1>
      <NewPlayer> name={name} updateName={updateName} survivorLevel={survivorLevel} updateSurvivorLevel={updateSurvivorLevel}
      </NewPlayer>
      <Zombies> zombies={zombies}</Zombies>
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
