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
  const [survivorLevel, setSurvivorLevel] = useState([]);
  const [survivor, setSurvivor] = useState("");
  const [zombies, setZombies] = useState([])

  const updateName = (name) => {
    setName(name)
  } 

  const updateSurvivorLevel = (survivorLevel) => {
    setSurvivorLevel(survivorLevel)
  }

  const updateSurvivor = (survivor) => {
    setSurvivor(survivor)
  }

  // useEffect(() => {
  //   fetch('http://localhost:8080/zombies')
  //   .then(resp => resp.json())
  //   .then(data => setZombies(data))
  // })

  // useEffect(() => {
  //   console.log(zombies)
  // }, [])

  const requestAll = function() {
    const request = new Request();
    const zombiePromise = request.get('http://localhost:8080/zombies')
    const survivorPromise = request.get('http://localhost:8080/survivors')
    const survivorLevelPromise = request.get('http://localhost:8080/survivorLevels')
    // .then((data) => {setZombies(data)})
    Promise.all([zombiePromise, survivorPromise, survivorLevelPromise])
    // .then(resp => resp.json())
    .then((data) => {
      // setZombies(data[0]);
      console.log("data0", data[0])
      setSurvivor(data[1]);
      console.log("data1", data[1])
      setSurvivorLevel(data[2])
      console.log("data2", data[2])
      console.log("slevel", survivorLevel)
    })
  }


  useEffect(() => {
    requestAll()
  }, [])

  // console.log(zombies)

  const handlePost = function(survivor){
    const request = new Request();
    request.post("/survivors", survivor)
    .then(() => window.location = '/survivors')
  }

  console.log("line 60", survivorLevel)

  if (survivorLevel.length == 0) {
    return  "SurvivorLevels here"
  }

  return (
    <div className="Game-start">
      <h1>Zombie Survival Adventure</h1>
      <NewPlayer name={name} updateName={updateName} survivorLevel={survivorLevel} updateSurvivorLevel={updateSurvivorLevel} survivor={survivor} setSurvivor={setSurvivor}/>
      <Zombies zombies={zombies}/>
      <Game name={name} survivorLevel={survivorLevel} survivor={survivor}/>
      {/* <Router>
      <Route exact path="/" component={NewPlayer} />
      <Route exact path="/game" component={Game} />
      </Router> */}
    </div>
  );
}

export default App;
