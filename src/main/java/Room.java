public class Room {
    private String name;
    private String description;
    private Room north = null;
    private Room south = null;
    private Room east = null;
    private Room west = null;

    public Room(String name, String description){
        this.name = name;
        this.description = description;
        this.north = null;
        this.south = null;
        this.east = null;
        this.west = null;
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

    public String toString() {
        return "You are in the " + name + "\n" + description;
    }
}
