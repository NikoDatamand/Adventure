import java.util.ArrayList;

public class Player {
    private Room currentRoom;
    private ArrayList<Item> inventory;


    public Player(){
        currentRoom = new Room(null, null);
        inventory = new ArrayList<Item>();
    }

    //Room metoder
    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(Room newCurrentRoom) {
        this.currentRoom = newCurrentRoom;
    }

    public boolean goNorth(){
        if (currentRoom.getNorth() != null) {
            setCurrentRoom(currentRoom.getNorth());
            return true;
        } else {
            return false;
        }
    }

    public boolean goSouth(){
        if (currentRoom.getSouth() != null) {
            setCurrentRoom(currentRoom.getSouth());
            return true;
        } else {
            return false;
        }
    }

    public boolean goEast(){
        if (currentRoom.getEast() != null) {
            setCurrentRoom(currentRoom.getEast());
            return true;
        } else {
            return false;
        }
    }

    public boolean goWest(){
        if (currentRoom.getWest() != null) {
            setCurrentRoom(currentRoom.getWest());
            return true;
        } else {
            return false;
        }
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

    public void removeItemFromInventory(Item item){
        int index = -1;
        for (int i = 0; i < inventory.size(); i++) {
            if (inventory.get(i) == item){
                index = i;
            }
        }
        inventory.remove(index);
    }
    public boolean takeItem(String itemName){
        boolean takeItem = false;
        Item requiredItem = currentRoom.searchItem(itemName);
        if(requiredItem != null){
            addItemToInventory(requiredItem);
            currentRoom.removeItemFromRoom(requiredItem);
            takeItem = true;
        }
        return takeItem;
    }

    public boolean dropItem(String itemName){
        boolean dropItem = false;
        Item requiredItem = searchItemInInventory(itemName);
        if(requiredItem != null){
            getCurrentRoom().addItem(requiredItem);
            removeItemFromInventory(requiredItem);
            dropItem = true;
        }
        return dropItem;
    }
}
