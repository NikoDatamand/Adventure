public class Player {
    private Room currentRoom;


    public Player(){
        currentRoom = new Room(null, null);
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }
    public void setCurrentRoom(Room newCurrentRoom) {
        this.currentRoom = newCurrentRoom;
    }
}
