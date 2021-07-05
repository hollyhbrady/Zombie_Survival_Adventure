

const Zombies = ({zombies}) => {
    
    if (!zombies) {
        return <p>Loading zombies</p>
    }

    const zombieList = zombies.map(zombie => {
        return zombie.name
    })

    return (
        {zombieList}
    )
}

export default Zombies;