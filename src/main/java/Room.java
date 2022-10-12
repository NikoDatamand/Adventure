import java.util.ArrayList;

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
        enemies.remove(index);
    }

    //ToString
    public String toString() {
        return "You are " + name + "\n" + description + "\n" + "You see: " + items + enemies;
    }
}
