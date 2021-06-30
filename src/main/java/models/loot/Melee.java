package models.loot;

public enum Melee {

    AXE(8, 50),
    BAT(5, 30);

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
