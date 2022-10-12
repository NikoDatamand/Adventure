public class Map {
    private Room room1 = null;
    private Room room2 = null;
    private Room room3 = null;
    private Room room4 = null;
    private Room room5 = null;
    private Room room6 = null;
    private Room room7 = null;
    private Room room8 = null;
    private Room room9 = null;

    public Room getRoom(Room room) {
        Room returnRoom = null;
        String roomName = room.getName();
        switch(roomName) {
            case "room1": {
                returnRoom = room1;
            }
            case "room2": {
                returnRoom = room2;
            }
            case "room3": {
                returnRoom = room3;
            }
            case "room4": {
                returnRoom = room4;
            }
            case "room5": {
                returnRoom = room5;
            }
            case "room6": {
                returnRoom = room6;
            }
            case "room7": {
                returnRoom = room7;
            }
            case "room8": {
                returnRoom = room8;
            }
            case "room9": {
                returnRoom = room9;
            }
        }
        return returnRoom;
    }

    public void createMap(){
        room1 = new Room("outside a bar", "This is your bar of choice. Every Friday it gathers programmers of all kinds to get lost in alcohol. But at this ungodly hour, don't even think about entering again!");
        room2 = new Room("in a dark alley", "This alleyway has an unpleasant odour of piss. Proceed at own risk...");
        room3 = new Room("inside a kiosk", "It is way too bright inside here! Goods of all kinds are to be found around you, from day-old candy to expensive magazines.");
        room4 = new Room("at the train station", "This station is sprayed with graffiti and poorly maintained. On top of all, the last train passed by many hours ago.");
        room5 = new Room("home", "Congratulations! You see your beloved kingsize bed, neatly prepared for a good nights sleep!");
        room6 = new Room("on a lonely road", "The joke writes itself.");
        room7 = new Room("in the park", "Inside the dark public park, you smell the local teens lighting up recreational plants.");
        room8 = new Room("at the bus stop", "A lonesome bus stop is just standing there. Looking at the timetables, it seems like luck is on your side. The busses are still driving!");
        room9 = new Room("in the P-area", "Situated between endless roads of parked cars. Good luck getting through!");

        setDirection(room1, null, room4, room2, null);
        setDirection(room2, null, null, room3, room1);
        setDirection(room3, null, room6, null, room2);
        setDirection(room4, room1, room7, null, null);
        setDirection(room5, null, room8, null, null);
        setDirection(room6, room3, room9, null, null);
        setDirection(room7, room4, null, room8, null);
        setDirection(room8, room5, null, room9, room7);
        setDirection(room9, room6, null, null, room8);

        addItemsToRoom(room1, "bowl", "bat", "book");
        addFoodToRoom(room1, "apple", 10, "poison", -10);
        addMeleeWeaponsToRoom(room2, "knife", -10);
        addRangedWeaponsToRoom(room2, "gun", -50, 1);
        addEnemiesToRoom(room4, "thug", 10, new MeleeWeapon("knife", -10));
    }

    //Add items
    public void addItemsToRoom(Room room, String itemName){
        room.addItem(new Item(itemName));
    }

    public void addItemsToRoom(Room room, String itemName1, String itemName2){
        room.addItem(new Item(itemName1));
        room.addItem(new Item(itemName2));
    }

    public void addItemsToRoom(Room room, String itemName1, String itemName2, String itemName3){
        room.addItem(new Item(itemName1));
        room.addItem(new Item(itemName2));
        room.addItem(new Item(itemName3));
    }

    //Add food
    public void addFoodToRoom(Room room, String itemName1, int healthPoints1 ){
        room.addItem(new Food(itemName1, healthPoints1));
    }

    public void addFoodToRoom(Room room, String itemName1, int healthPoints1, String itemName2, int healthPoints2){
        room.addItem(new Food(itemName1, healthPoints1));
        room.addItem(new Food(itemName2, healthPoints2));
    }

    public void addFoodToRoom(Room room, String itemName1, int healthPoints1, String itemName2, int healthPoints2, String itemName3, int healthPoints3){
        room.addItem(new Food(itemName1, healthPoints1));
        room.addItem(new Food(itemName2, healthPoints2));
        room.addItem(new Food(itemName3, healthPoints3));
    }

    //Add weapons

    //Add RangedWeapons
    public void addRangedWeaponsToRoom(Room room, String itemName1, int damage1, int uses1){
        room.addItem(new RangedWeapon(itemName1, damage1, uses1));
    }

    public void addRangedWeaponsToRoom(Room room, String itemName1, int damage1, int uses1, String itemName2, int damage2, int uses2){
        room.addItem(new RangedWeapon(itemName1, damage1, uses1));
        room.addItem(new RangedWeapon(itemName2, damage2, uses2));
    }

    public void addRangedWeaponsToRoom(Room room, String itemName1, int damage1, int uses1, String itemName2, int damage2, int uses2, String itemName3, int damage3, int uses3){
        room.addItem(new RangedWeapon(itemName1, damage1, uses1));
        room.addItem(new RangedWeapon(itemName2, damage2, uses2));
        room.addItem(new RangedWeapon(itemName3, damage3, uses3));
    }

    //Add MeleeWeapons
    public void addMeleeWeaponsToRoom(Room room, String itemName1, int damage1){
        room.addItem(new MeleeWeapon(itemName1, damage1));
    }

    public void addMeleeWeaponsToRoom(Room room, String itemName1, int damage1, String itemName2, int damage2){
        room.addItem(new MeleeWeapon(itemName1, damage1));
        room.addItem(new MeleeWeapon(itemName2, damage2));
    }

    public void addMeleeWeaponsToRoom(Room room, String itemName1, int damage1, String itemName2, int damage2, String itemName3, int damage3){
        room.addItem(new MeleeWeapon(itemName1, damage1));
        room.addItem(new MeleeWeapon(itemName2, damage2));
        room.addItem(new MeleeWeapon(itemName3, damage3));
    }

    //Add enemies
    public void addEnemiesToRoom(Room room, String enemyName1, int enemyHealth1, Weapon enemyWeapon1){
        room.addEnemy(new Enemy(enemyName1, enemyHealth1, enemyWeapon1));
    }

    public void addEnemiesToRoom(Room room, String enemyName1, String enemyName2, int enemyHealth1, int enemyHealth2, Weapon enemyWeapon1, Weapon enemyWeapon2){
        room.addEnemy(new Enemy(enemyName1, enemyHealth1, enemyWeapon1));
        room.addEnemy(new Enemy(enemyName2, enemyHealth2, enemyWeapon2));
    }

    public void addEnemiesToRoom(Room room, String enemyName1, String enemyName2, String enemyName3, int enemyHealth1, int enemyHealth2, int enemyHealth3, Weapon enemyWeapon1, Weapon enemyWeapon2, Weapon enemyWeapon3){
        room.addEnemy(new Enemy(enemyName1, enemyHealth1, enemyWeapon1));
        room.addEnemy(new Enemy(enemyName2, enemyHealth2, enemyWeapon2));
        room.addEnemy(new Enemy(enemyName3, enemyHealth3, enemyWeapon3));
    }

    //Add directions
    public void setDirection(Room room, Room north, Room south, Room east, Room west){
        room.setNorth(north);
        room.setSouth(south);
        room.setEast(east);
        room.setWest(west);
    }

    public Room getStartRoom(){
        return room1;
    }

}
