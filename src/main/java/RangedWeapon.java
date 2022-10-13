public class RangedWeapon extends Weapon {

    private int uses;

    public RangedWeapon(String name, String description, boolean isLocked, int lockID, int damage, int uses) {
        super(name, description, isLocked, lockID, damage);
        this.uses = uses;
    }

    public int getUses() {
        return uses;
    }

    public void rangedWeaponUsed(){
        uses--;
    }
}
