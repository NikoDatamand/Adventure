public class Weapon extends Item {

    private int damage;

    public Weapon(String name, String description, boolean isLocked, int lockID, int damage) {
        super(name, description, isLocked, lockID);
        this.damage = damage;
    }

    public int getDamage() {
        return damage;
    }


}
