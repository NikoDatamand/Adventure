public class Enemy {

    private String name;
    private int health;
    private Weapon enemyAttackWeapon;

    public Enemy (String name, int health, Weapon enemyAttackWeapon) {
        this.name = name;
        this.health = health;
        this.enemyAttackWeapon = enemyAttackWeapon;
    }

    //GET
    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public Weapon getEnemyAttackWeapon() {
        return enemyAttackWeapon;
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

    //ToString
    public String toString() {
        return "a "+ name + " holding a " + enemyAttackWeapon + " with " + health + " HP";
    }
}
