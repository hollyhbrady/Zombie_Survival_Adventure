package Holly.Zombie_Survival_Adventure.models.loot;

import Holly.Zombie_Survival_Adventure.models.Survivor;

public abstract class Loot {

    private Gun gun;
    private Melee melee;
    public Food food;
    private int ammo;

    public Loot(Gun gun, Melee melee, Food food, int ammo) {
        this.gun = gun;
        this.melee = melee;
        this.food = food;
        this.ammo = ammo;
    }

    public Gun getGun() {
        return gun;
    }

    public void setGun(Gun gun) {
        this.gun = gun;
    }

    public Melee getMelee() {
        return melee;
    }

    public void setMelee(Melee melee) {
        this.melee = melee;
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
