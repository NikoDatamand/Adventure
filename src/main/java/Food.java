public class Food extends Item {

    private int healthPoints;

    public Food(String name, int healthPoints) {
        super(name);
        this.healthPoints = healthPoints;
    }

    //GET metoder
    public int getHealthPoints() {
        return healthPoints;
    }
}
