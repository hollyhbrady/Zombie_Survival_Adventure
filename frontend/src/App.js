import './App.css';

import React from "react";
import { BrowserRouter as Router, Route, Switch } from "react-router-dom";
import Player from "./components/Player";
import Game from "./components/Game";

const App = () => {
  return (
    <div className="Game-start">
      <Router>
      <Route exact path="/" component={Player} />
//      <Route exact path="/game" component={Game} />
      </Router>
    </div>
  );
}

export default App;
