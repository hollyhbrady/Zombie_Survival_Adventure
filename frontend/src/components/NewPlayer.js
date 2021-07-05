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

  const survivorLevelOptions = survivorLevel.map((survivorLevel, index) => {
    return <option key={index} value={index}>{survivorLevel}</option>
  })

  return (
    <form action="">
      <input 
      required
      type="text"
      placeholder="Name" 
      value={name}
      onChange={handleNameChange}
      />
      <select name="survivorLevel" onChange={handleSurvivorLevelChange}>
        <option disabled value="Select a player type"></option>
        {survivorLevelOptions}
      </select>
      <input 
      required
      type="select"
      value={survivorLevel}
      onChange={handleSurvivorLevelChange}
       />
       <input 
       type="submit"
       value="Play"
        />
    </form>
  );

}

export default NewPlayer;
