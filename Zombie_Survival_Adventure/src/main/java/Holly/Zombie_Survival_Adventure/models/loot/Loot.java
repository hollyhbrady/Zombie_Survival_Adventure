package Holly.Zombie_Survival_Adventure.models.loot;

public abstract class Loot {

    private models.loot.Gun gun;
    private models.loot.Melee melee;
    public models.loot.Food food;
    private int ammo;

    public Loot(models.loot.Gun gun, models.loot.Melee melee, models.loot.Food food, int ammo) {
        this.gun = gun;
        this.melee = melee;
        this.food = food;
        this.ammo = ammo;
    }

    public models.loot.Gun getGun() {
        return gun;
    }

    public void setGun(models.loot.Gun gun) {
        this.gun = gun;
    }

    public models.loot.Melee getMelee() {
        return melee;
    }

    public void setMelee(models.loot.Melee melee) {
        this.melee = melee;
    }

    public models.loot.Food getFood() {
        return food;
    }

    public void setFood(models.loot.Food food) {
        this.food = food;
    }

    public int getAmmo() {
        return ammo;
    }

    public void setAmmo(int ammo) {
        this.ammo = ammo;
    }
}
