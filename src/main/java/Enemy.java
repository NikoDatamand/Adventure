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

    //ToString
    public String toString() {
        return "a "+ name + " holding a " + enemyAttackWeapon + " with " + health + " HP";
    }
}
