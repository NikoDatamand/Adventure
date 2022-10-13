import java.util.ArrayList;
import java.util.Objects;

public class Room {
    private String name;
    private String description;
    private Room north = null;
    private Room south = null;
    private Room east = null;
    private Room west = null;
    private ArrayList<Item> items;
    private ArrayList<Enemy> enemies;

    public Room(String name, String description){
        this.name = name;
        this.description = description;
        this.north = null;
        this.south = null;
        this.east = null;
        this.west = null;
        items = new ArrayList<Item>();
        enemies = new ArrayList<Enemy>();
    }

    //Gettere
    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Room getNorth() {
        return north;
    }

    public Room getSouth() {
        return south;
    }

    public Room getEast() {
        return east;
    }

    public Room getWest() {
        return west;
    }

    //Settere

    public void setNorth(Room northRoom) {
        this.north = northRoom;
    }

    public void setSouth(Room southRoom) {
        this.south = southRoom;
    }

    public void setEast(Room eastRoom) {
        this.east = eastRoom;
    }

    public void setWest(Room westRoom) {
        this.west = westRoom;
    }

    public void addItem(Item item){
        items.add(item);
    }

    public Item searchItem(String item){
        for (Item s: items) {
            if(s.getName().equals(item))
                return s;
        }
        return null;
    }

    public Item searchItemFromLockID(int keyID){
        for (Item s: items) {
            if(s.getLockID() == keyID)
                return s;
        }
        return null;
    }

    public void removeItemFromRoom(Item item){
        int index = -1;
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i) == item){
                index = i;
            }
        }
        items.remove(index);
    }

    //Enemy methods
    public void addEnemy(Enemy enemy){
        enemies.add(enemy);
    }

    public Enemy searchEnemy(String enemyName){
        for (Enemy e: enemies) {
            if(e.getName().equals(enemyName))
                return e;
        }
        return null;
    }

    public void removeEnemiesFromRoom(Enemy enemy){
        int index = -1;
        for (int i = 0; i < enemies.size(); i++) {
            if (enemies.get(i) == enemy){
                index = i;
            }
        }
        System.out.println(enemy.getName() + " is dead! ");
        if (!Objects.equals(enemy.getEnemyAttackWeapon().getName(), "fists") && !Objects.equals(enemy.getEnemyAttackWeapon().getName(), "punch") && !Objects.equals(enemy.getEnemyAttackWeapon().getName(), "bite")) {
            items.add(enemy.dropWeapon());
            System.out.print(enemy.getEnemyAttackWeapon().getDescription() + " " + enemy.getEnemyAttackWeapon().getName());
        }

        if (enemy.getCarriedItem() != null) {
            items.add(enemy.dropCarriedItem());
            if (!Objects.equals(enemy.getEnemyAttackWeapon().getName(), "fists") && !Objects.equals(enemy.getEnemyAttackWeapon().getName(), "punch") && !Objects.equals(enemy.getEnemyAttackWeapon().getName(), "bite")) {
                System.out.print(" and ");
            }
            System.out.print(enemy.getCarriedItem().getDescription() + " " + enemy.getCarriedItem().getName());
        }

        if (Objects.equals(enemy.getEnemyAttackWeapon().getName(), "fists") && Objects.equals(enemy.getEnemyAttackWeapon().getName(), "punch") && Objects.equals(enemy.getEnemyAttackWeapon().getName(), "bite") && enemy.getCarriedItem() == null) {
            System.out.print(" nothing");
        }

        System.out.print(" was dropped");
        enemies.remove(index);
    }

    //ToString
    public String toString() {
        String string = "";
        string += "You are " + name + '\n' + description;
        if(items.isEmpty()){
            string += "";
        } else {
            for (Item i: items) {
                string += "\nYou see " + i.getDescription() + " " + i.getName();
            }
        }
        if(enemies.isEmpty()){
            string += "";
        } else {
            for (Enemy e: enemies) {
                string += "\nThere is " + e.getDescription() + " " + e.getName();
            }
        }
        return string;
    }

}
