import java.util.ArrayList;

public class Player {
    private Room currentRoom;
    private ArrayList<Item> inventory;


    public Player(){
        currentRoom = new Room(null, null);
        inventory = new ArrayList<>();
    }

    //Room metoder
    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(Room newCurrentRoom) {
        this.currentRoom = newCurrentRoom;
    }

    //Item metoder
    public void addItemToInventory(Item item){
        inventory.add(item);
    }

    public Item searchItemInInventory(String item){
        for (Item s: inventory) {
            if(s.getName().equals(item))
                return s;
        }
        return null;
    }

    public ArrayList<Item> printInventory() {
        return inventory;
    }

    public void deleteItemFromInventory(Item item){
        for (Item s: inventory) {
            if(s.getName().equals(item.getName()))
                inventory.remove(s);
        }
    }
}
