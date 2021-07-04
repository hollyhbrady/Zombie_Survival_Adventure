import './App.css';

function NewPlayer() {

    const [name, setName] = React.useState("");
    const [survivorLevel, setSurvivorLevel] = React.useState("");

    const handleNameChange = event => setName(event.target.value);
    const handleSurvivorLevelChange = event => setSurvivorLevel(event.target.value);

    const handleSubmit = variables => {
        const toInput = { name, survivorLevel};
        sampleFunc(toInput);
        setName("");
        setSurvivorLevel("");
    };

    if (firstLoad) {
      setLoad(false);
    }

    return (
    <Grid container spacing={2}>
        <Grid item xs={12}>
          <TextField
            variant="outlined"
            required
            fullWidth
            id="name"
            value={name}
            label="Name"
            name="name"
            autoComplete="name"
            onChange={handleNameChange}
          />
        </Grid>
        <Grid item xs={12} sm={6}>
          <TextField
            autoComplete="survivorLevel"
            name="survivorLevel"
            variant="outlined"
            required
            fullWidth
            value={survivorLevel}
            id="survivorLevel"
            label="survivorLevel"
            onChange={handleSurvivorLevelChange}
          />
      </Grid>
      <Button
        fullWidth
        variant="contained"
        color="primary"
        preventDefault
        className={classes.submit}
        onClick={handleSubmit}
      >
        Save
      </Button>
    )

}

export default App;
