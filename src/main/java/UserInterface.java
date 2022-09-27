import java.util.Scanner;
public class UserInterface {
    Adventure adventure = new Adventure();
    Scanner sc = new Scanner(System.in);

    public void start(){
        adventure.createMap();
        System.out.println(adventure.getCurrentRoom());
        handleInput();
    }
    public void handleInput(){
        while (true) {
            System.out.println("What do you want to do?");
            String action = sc.nextLine();

            switch (action) {
                case "go north":
                    if (adventure.getCurrentRoom().getNorth() != null) {
                        adventure.setCurrentRoom(adventure.getCurrentRoom().getNorth());
                        System.out.println("going north");
                        System.out.println(adventure.getCurrentRoom());
                    } else if (adventure.getCurrentRoom().getNorth() == null) {
                        System.out.println("You can't go that way!");
                    }
                    break;

                case "go south":
                    if (adventure.getCurrentRoom().getSouth() != null) {
                        adventure.setCurrentRoom(adventure.getCurrentRoom().getSouth());
                        System.out.println("going south");
                        System.out.println(adventure.getCurrentRoom());
                    } else if (adventure.getCurrentRoom().getSouth() == null) {
                        System.out.println("You can't go that way!");
                    }
                    break;

                case "go east":
                    if (adventure.getCurrentRoom().getEast() != null) {
                        adventure.setCurrentRoom(adventure.getCurrentRoom().getEast());
                        System.out.println("going east");
                        System.out.println(adventure.getCurrentRoom());
                    } else if (adventure.getCurrentRoom().getEast() == null) {
                        System.out.println("You can't go that way!");
                    }
                    break;

                case "go west":
                    if (adventure.getCurrentRoom().getWest() != null) {
                        adventure.setCurrentRoom(adventure.getCurrentRoom().getWest());
                        System.out.println("going west");
                        System.out.println(adventure.getCurrentRoom());
                    } else if (adventure.getCurrentRoom().getWest() == null) {
                        System.out.println("You can't go that way!");
                    }
                    break;

                case "look":
                    System.out.println(adventure.getCurrentRoom());
                    break;

                default:
                    System.out.println("Invalid request, try again.");
                    break;
            }
        }
    }

}
