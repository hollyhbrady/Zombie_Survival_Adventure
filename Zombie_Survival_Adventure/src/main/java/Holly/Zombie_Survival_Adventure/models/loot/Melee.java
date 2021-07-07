package Holly.Zombie_Survival_Adventure.models.loot;

public enum Melee {

    KNIFE(5, 50);

    private int damage;
    private int uses;

    Melee(int damage, int uses) {
        this.damage = damage;
        this.uses = uses;
    }

    public int getDamage() {
        return damage;
    }

    public int getUses() {
        return uses;
    }
}
