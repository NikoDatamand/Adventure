public class Item {
    private String name;

    public Item(String name){
        this.name = name;
    }

    public Item(Item source){
        this.name = source.name;
    }

    public String getName() {
        return name;
    }

    public String toString(){
        return name;
    }
}
