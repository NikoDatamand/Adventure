public class Food extends Item {

    private int healthPoints;
    private int uses;

    public Food(String name, String description, boolean islocked, int lockID, int healthPoints, int uses) {
        super(name, description, islocked, lockID);
        this.healthPoints = healthPoints;
        this.uses = uses;
    }

    //GET metoder
    public int getHealthPoints() {
        return healthPoints;
    }

    public int getUses() {
        return uses;
    }

    public void consumableUsed(){
        uses--;
    }
}
