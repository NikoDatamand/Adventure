import java.util.ArrayList;
import java.util.Objects;

public class Player {
    private Room currentRoom;
    private ArrayList<Item> inventory;
    private int health;
    private Weapon equippedWeapon;

    public Player(int health){
        currentRoom = new Room(null, null);
        inventory = new ArrayList<Item>();
        this.health = health;
        this.equippedWeapon = null;
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

    public int searchItemIndex (String x) {
        int superheroIndex = 0;
        for (Item y : inventory) {
            if (y.getName().contains(x)) {
                superheroIndex = inventory.indexOf(y);
            }
        }
        return superheroIndex;
    }

    public boolean doesItemExist(String itemName){
        boolean doesItemExist = false;
        Item itemInQuestion = searchItemInInventory(itemName);
        if(itemInQuestion != null){
            doesItemExist = true;
        }
        return doesItemExist;
    }

    //Food methods
    public Food searchFoodInInventory(String item){
        for (Item s: inventory) {
            if(s instanceof Food food)
                if (food.getName().equals(item)){
                    return food;
                }
        }
        return null;
    }

    public void eatFood(String foodEaten){
        inventory.get(searchItemIndex(foodEaten));
        inventory.remove(searchItemIndex(foodEaten));
    }

    //Health metoder
    public int getHealth() {
        return health;
    }

    public void changeHealth(int changeValue){
        if (changeValue >= 0) {
            health = health + changeValue;
        } else {
            health = health + changeValue;
        }
    }

    //Weapon metoder
    public Weapon searchWeaponInInventory(String item){
        for (Item s: inventory) {
            if(s instanceof Weapon weapon)
                if (weapon.getName().equals(item)){
                    return weapon;
                }
        }
        return null;
    }

    public boolean isRangedWeapon(String item){
        for (Item s: inventory) {
            if(s instanceof RangedWeapon rangedWeapon)
                if (rangedWeapon.getName().equals(item)){
                    return true;
                }
        }
        return false;
    }

    public RangedWeapon useRangedWeapon(String item){
        for (Item s: inventory) {
            if(s instanceof RangedWeapon rangedWeapon)
                if (rangedWeapon.getName().equals(item)){
                    return rangedWeapon;
                }
        }
        return null;
    }

    public void equipWeapon(Weapon weaponEquipped){
        equippedWeapon = weaponEquipped;
    }

    public void unEquipWeapon(Weapon weaponUnEquipped){
        equippedWeapon = weaponUnEquipped;
    }

    public Weapon getEquippedWeapon() {
        return equippedWeapon;
    }
}
