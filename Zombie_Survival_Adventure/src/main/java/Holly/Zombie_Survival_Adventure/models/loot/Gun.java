package models.loot;

public enum Gun {

    HANDGUN(11, 30, 6),
    RIFLE(25, 20, 2);

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
