package models.loot;

public enum Food {

    BAKEDBEANS(20),
    DRIEDFRUIT(10),
    IRNBRU(5);

    private final int restore;

    Food(int restore) {
        this.restore = restore;
    }

    public int getRestore() {
        return restore;
    }
}
