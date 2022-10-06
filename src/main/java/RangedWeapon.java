public class RangedWeapon extends Weapon {

    private int uses;

    public RangedWeapon(String name, int damage, int uses) {
        super(name, damage);
        this.uses = uses;
    }

    public int getUses() {
        return uses;
    }

    public void rangedWeaponUsed(){
        uses--;
    }
}
