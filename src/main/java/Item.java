public class Item {
    private String name;
    private String description;
    private boolean isLocked;
    private int lockID;

    public Item(String name, String description, boolean isLocked, int lockID){
        this.name = name;
        this.description = description;
        this.isLocked = isLocked;
        this.lockID = lockID;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String toString(){
        return description + " " + name;
    }

    public int getLockID() {
        return lockID;
    }

    public boolean isLocked(){
        return isLocked;
    }

    public void unlock(){
        isLocked = false;
    }

}
