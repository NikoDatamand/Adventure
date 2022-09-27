public class Adventure {

    private Room library = new Room("Library", "Lots of books");

    private Room currentRoom = library;

    //Gettere
    public Room getLibrary() {
        return library;
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }
}
