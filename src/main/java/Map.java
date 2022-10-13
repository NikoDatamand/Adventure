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

    public Room getRoomByNumber(int roomID) {
        switch(roomID) {
            case 1: {
                return room1;
            }
            case 2: {
                return room2;
            }
            case 3: {
                return room3;
            }
            case 4: {
                return room4;
            }
            case 5: {
                return room5;
            }
            case 6: {
                return room6;
            }
            case 7: {
                return room7;
            }
            case 8: {
                return room8;
            }
            case 9: {
                return room9;
            }
        }
        return null;
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
        setDirection(room8, null, null, room9, room7);
        setDirection(room9, room6, null, null, room8);

        addFoodToRoom(room1, "cigarettes", "a unopened pack of", false, 0, 10, 20);
        addFoodToRoom(room4, "taquito", "a leftover spicy", false, 0, 20, 1);
        addFoodToRoom(room3, "energydrink", "a posionous looking", true, 1, 20, 1);
        addFoodToRoom(room3, "samosa", "a steaming hot", true, 2, 50, 1);
        addMeleeWeaponsToRoom(room2, "knife", "a ", false, 0, -40);
        addEnemiesToRoom(room2, "hobo", "a stinky", 60, new MeleeWeapon("fists", "his ", false, 0, -5), new Key("change", "some spare ", false, 0, 1));
        addEnemiesToRoom(room3, "kiosk_owner", "an old and angry", 100, new RangedWeapon("shotgun", "", false, 0, -100, 5), null);
        addEnemiesToRoom(room4, "rat", "a mutated", 40, new MeleeWeapon("bite", "a disgusting", false, 0, -15), new Key("money ", "some lost ", false, 0, 2));
        addEnemiesToRoom(room7, "bully", "a young", 80, new RangedWeapon("slingshot", "a ", false, 0, -20, 5), null);
        addEnemiesToRoom(room7, "bully2", "an older", 80, new RangedWeapon("slingshot", "a ", false, 0, -20, 5), new Food("joint", "a fat rolled all-green ", false, 0, 0, 1));
        addEnemiesToRoom(room9, "thug1", "a threatening", 120, new MeleeWeapon("punch", "a packed", false, 0, -20), null);
        addEnemiesToRoom(room9, "thug2", "a threatening", 120, new MeleeWeapon("punch", "a packed", false, 0, -20), new Key("card", "a stolen transit", false, 0, 3));
        addEnemiesToRoom(room9, "thug3", "a threatening", 120, new MeleeWeapon("punch", "a packed", false, 0, -20), null);
    }

    //Add food
    public void addFoodToRoom(Room room, String itemName1, String description1, boolean isLocked1, int lockID1, int healthPoints1, int uses){
        room.addItem(new Food(itemName1, description1, isLocked1, lockID1, healthPoints1, uses));
    }

    public void addFoodToRoom(Room room, String itemName1, String description1, boolean isLocked1, int lockID1, int healthPoints1, int uses1, String itemName2, String description2, boolean isLocked2, int lockID2, int healthPoints2, int uses2){
        room.addItem(new Food(itemName1, description1, isLocked1, lockID1, healthPoints1, uses1));
        room.addItem(new Food(itemName2, description2, isLocked2, lockID2, healthPoints2, uses2));
    }

    //Add keys
    public void addKeyToRoom(Room room, String keyName1, String keyDescription1, boolean isLocked1, int lockID1, int keyID1) {
        room.addItem(new Key(keyName1, keyDescription1, isLocked1, lockID1, keyID1));
    }

    //Add weapons

    //Add RangedWeapons
    public void addRangedWeaponsToRoom(Room room, String weaponName1, String weaponDescription1, boolean isLocked1, int lockID1, int damage1, int uses1){
        room.addItem(new RangedWeapon(weaponName1, weaponDescription1, isLocked1, lockID1, damage1, uses1));
    }

    public void addRangedWeaponsToRoom(Room room, String weaponName1, String weaponDescription1, boolean isLocked1, int lockID1, int damage1, int uses1, String weaponName2,  String weaponDescription2, boolean isLocked2, int lockID2, int damage2, int uses2){
        room.addItem(new RangedWeapon(weaponName1, weaponDescription1, isLocked1, lockID1, damage1, uses1));
        room.addItem(new RangedWeapon(weaponName2, weaponDescription2, isLocked2, lockID2, damage2, uses2));
    }

    //Add MeleeWeapons
    public void addMeleeWeaponsToRoom(Room room, String weaponName1, String weaponDescription1, boolean isLocked1, int lockID1, int damage1){
        room.addItem(new MeleeWeapon(weaponName1, weaponDescription1, isLocked1, lockID1, damage1));
    }

    public void addMeleeWeaponsToRoom(Room room, String weaponName1, String weaponDescription1, boolean isLocked1, int lockID1, int damage1, String weaponName2, String weaponDescription2, boolean isLocked2, int lockID2, int damage2){
        room.addItem(new MeleeWeapon(weaponName1, weaponDescription1, isLocked1, lockID1, damage1));
        room.addItem(new MeleeWeapon(weaponName2, weaponDescription2, isLocked2, lockID2, damage2));
    }

    //Add enemies
    public void addEnemiesToRoom(Room room, String enemyName1, String enemyDescription1, int enemyHealth1, Weapon enemyWeapon1, Item carriedItem1){
        room.addEnemy(new Enemy(enemyName1,  enemyDescription1, enemyHealth1, enemyWeapon1, carriedItem1));
    }

    public void addEnemiesToRoom(Room room, String enemyName1,  String enemyName2, String enemyDescription1, String enemyDescription2, int enemyHealth1, int enemyHealth2,  Weapon enemyWeapon1, Weapon enemyWeapon2, Item carriedItem1, Item carriedItem2){
        room.addEnemy(new Enemy(enemyName1, enemyDescription1, enemyHealth1, enemyWeapon1, carriedItem1));
        room.addEnemy(new Enemy(enemyName2, enemyDescription2, enemyHealth2,enemyWeapon2, carriedItem2));
    }

    public void addEnemiesToRoom(Room room, String enemyName1, String enemyName2, String enemyName3, String enemyDescription1, String enemyDescription2, String enemyDescription3, int enemyHealth1, int enemyHealth2, int enemyHealth3, Weapon enemyWeapon1, Weapon enemyWeapon2, Weapon enemyWeapon3, Item carriedItem1, Item carriedItem2, Item carriedItem3){
        room.addEnemy(new Enemy(enemyName1, enemyDescription1, enemyHealth1, enemyWeapon1, carriedItem1));
        room.addEnemy(new Enemy(enemyName2, enemyDescription2, enemyHealth2, enemyWeapon2, carriedItem2));
        room.addEnemy(new Enemy(enemyName3, enemyDescription3, enemyHealth3, enemyWeapon3, carriedItem3));
    }


    //Add directions
    public void setDirection(Room room, Room north, Room south, Room east, Room west){
        room.setNorth(north);
        room.setSouth(south);
        room.setEast(east);
        room.setWest(west);
    }

    public void finalKey(){
        room8.setNorth(room5);
        room8.setSouth(null);
        room8.setEast(room7);
        room8.setWest(room9);
    }

    public Room getStartRoom(){
        return room1;
    }

}
