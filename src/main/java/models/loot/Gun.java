package models.loot;

public enum Gun {

    HANDGUN(15, 30, 6),
    RIFLE(20, 20, 2);

    private int damage;
    private int uses;
    private int capacity;

    Gun(int damage, int uses, int capacity) {
        this.damage = damage;
        this.uses = uses;
        this.capacity = capacity;
    }

    public int getDamage() {
        return damage;
    }

    public int getUses() {
        return uses;
    }

    public int getCapacity() {
        return capacity;
    }
}
