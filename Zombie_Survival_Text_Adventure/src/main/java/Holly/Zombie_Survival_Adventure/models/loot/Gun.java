package Holly.Zombie_Survival_Adventure.models.loot;

public enum Gun {

    HANDGUN(11, 10, 6),
    RIFLE(25, 6, 2);

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
