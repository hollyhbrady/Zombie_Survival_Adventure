import '../App.css';
import React, {useState} from 'react';

const NewPlayer = ({name, updateName, survivorLevel, updateSurvivorLevel}) => {

  

  const handleNameChange = event => { 
    updateName(event.target.value);
  }

  const handleSurvivorLevelChange = event => {
    updateSurvivorLevel(event.target.value);
  }

  const handleSubmit = (event) => {
    event.preventDefault();
    const nameToSubmit = name.trim();
    const survivorLevelToSubmit = 
      updateName("");
      updateSurvivorLevel("");
  };

  return (
    <form action="">
      <input 
      required
      type="text"
      placeholder="Name" 
      value={name}
      onChange={handleNameChange}
      />
      <input 
      required
      type="text"
      value={survivorLevel}
      onChange={handleSurvivorLevelChange}
       />
       <input 
       type="submit"
       value="Post"
        />
    </form>
    // <Grid container spacing={2}>
    //   <Grid item xs={12}>
    //     <TextField
    //       required
    //       fullWidth
    //       id="name"
    //       value={name}
    //       label="Name"
    //       name="name"
    //       autoComplete="name"
    //       onChange={handleNameChange}
    //     />
    // </Grid>
    //   <Grid item xs={12} sm={6}>
    //     <TextField
    //       autoComplete="survivorLevel"
    //       name="survivorLevel"
    //       variant="outlined"
    //       required
    //       fullWidth
    //       value={survivorLevel}
    //       id="survivorLevel"
    //       label="survivorLevel"
    //       onChange={handleSurvivorLevelChange}
    //     />
    
  );

}

export default NewPlayer;
