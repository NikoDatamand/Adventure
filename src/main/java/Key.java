public class Key extends Item {
    private int keyID;

    public Key(String name, String description, boolean isLocked, int lockID, int keyID){
        super(name, description, isLocked, lockID);
        this.keyID = keyID;
    }

    public int getKeyID() {
        return keyID;
    }
}
