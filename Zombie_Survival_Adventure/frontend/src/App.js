import './App.css';

function App() {
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
