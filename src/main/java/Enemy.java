public class Enemy {

    private String name;
    private String description;
    private int health;
    private Weapon enemyAttackWeapon;
    private Item carriedItem;

    public Enemy (String name, String description, int health, Weapon enemyAttackWeapon, Item carriedItem) {
        this.name = name;
        this.description = description;
        this.health = health;
        this.enemyAttackWeapon = enemyAttackWeapon;
        this.carriedItem = carriedItem;
    }

    //GET
    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getHealth() {
        return health;
    }

    public Weapon getEnemyAttackWeapon() {
        return enemyAttackWeapon;
    }

    public Item getCarriedItem() {
        return carriedItem;
    }

    //SET
    public void changeHealth(int changeValue){
        if (changeValue >= 0) {
            health = health + changeValue;
        } else {
            health = health + changeValue;
        }
    }

    //Attack
    public int attackPlayer(){
            if (enemyAttackWeapon instanceof RangedWeapon) {
                if (((RangedWeapon) enemyAttackWeapon).getUses() > 0) {
                    ((RangedWeapon) enemyAttackWeapon).rangedWeaponUsed();
                    System.out.println("Enemy attacks with " + enemyAttackWeapon.getName() + " it has " + ((RangedWeapon) enemyAttackWeapon).getUses() + " ammo left.");
                    return enemyAttackWeapon.getDamage();
                } else if (((RangedWeapon) enemyAttackWeapon).getUses() <= 0) {
                    System.out.println("The enemy seems to be out of ammo... ");
                    return 0;
                }
            } else if (enemyAttackWeapon instanceof MeleeWeapon) {
                System.out.println("Enemy attacks with " + enemyAttackWeapon.getName());
                return enemyAttackWeapon.getDamage();
            }
            return 0;
        }

    public Weapon dropWeapon(){
        return enemyAttackWeapon;
    }

    public Item dropCarriedItem() {
        return carriedItem;
    }

    //ToString
    public String toString() {
        return "a "+ name + " holding a " + enemyAttackWeapon + " with " + health + " HP";
    }
}
