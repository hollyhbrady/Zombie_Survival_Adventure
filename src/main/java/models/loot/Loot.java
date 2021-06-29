package models.loot;

public class Loot {

    private Weapon weapon;
    private Food food;
    private int ammo;

    public Loot(Weapon weapon, Food food, int ammo) {
        this.weapon = weapon;
        this.food = food;
        this.ammo = ammo;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public Food getFood() {
        return food;
    }

    public void setFood(Food food) {
        this.food = food;
    }

    public int getAmmo() {
        return ammo;
    }

    public void setAmmo(int ammo) {
        this.ammo = ammo;
    }
}
