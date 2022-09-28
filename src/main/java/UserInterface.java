import java.util.Scanner;
public class UserInterface {
    Adventure adventure;
    Scanner sc;

    public UserInterface(){
        adventure = new Adventure();
        sc = new Scanner(System.in);
    }
    public void start(){
        System.out.println(adventure.player.getCurrentRoom());
        handleInput();
    }
    public void handleInput(){
        while (true) {
            System.out.println("What do you want to do?");
            String action = sc.nextLine().toLowerCase();

//            //Alternative inputs
//            if (action.equals("n") || action.contains("north")) {
//                action = "go north";
//            } else if (action.equals("s")   || action.contains("south")) {
//                action = "go south";
//            } else if (action.equals("e") || action.contains("east")) {
//                action = "go east";
//            } else if (action.equals("w")  || action.contains("west")) {
//                action = "go west";
//            }

            switch (action) {
                case "go north", "north", "n" -> {
                    if (adventure.player.getCurrentRoom().getNorth() != null) {
                        adventure.player.setCurrentRoom(adventure.player.getCurrentRoom().getNorth());
                        System.out.println("going north");
                        System.out.println(adventure.player.getCurrentRoom());
                    } else if (adventure.player.getCurrentRoom().getNorth() == null) {
                        System.out.println("You can't go that way!");
                    }
                }

                case "go south", "south", "s" -> {
                    if (adventure.player.getCurrentRoom().getSouth() != null) {
                        adventure.player.setCurrentRoom(adventure.player.getCurrentRoom().getSouth());
                        System.out.println("going south");
                        System.out.println(adventure.player.getCurrentRoom());
                    } else if (adventure.player.getCurrentRoom().getSouth() == null) {
                        System.out.println("You can't go that way!");
                    }
                }

                case "go east", "east", "e" -> {
                    if (adventure.player.getCurrentRoom().getEast() != null) {
                        adventure.player.setCurrentRoom(adventure.player.getCurrentRoom().getEast());
                        System.out.println("going east");
                        System.out.println(adventure.player.getCurrentRoom());
                    } else if (adventure.player.getCurrentRoom().getEast() == null) {
                        System.out.println("You can't go that way!");
                    }
                }

                case "go west", "west", "w" -> {
                    if (adventure.player.getCurrentRoom().getWest() != null) {
                        adventure.player.setCurrentRoom(adventure.player.getCurrentRoom().getWest());
                        System.out.println("going west");
                        System.out.println(adventure.player.getCurrentRoom());
                    } else if (adventure.player.getCurrentRoom().getWest() == null) {
                        System.out.println("You can't go that way!");
                    }
                }

                case "look" -> System.out.println(adventure.player.getCurrentRoom());
                case "help" -> System.out.println("""
                                                
                                                COMMANDS:
                                                
                                                go north
                                                go south
                                                go east
                                                go west
                                                look
                                                exit
                                                
                                                """);


                case "exit" -> System.exit(0);
                default-> System.out.println("Invalid request, try again.");
            }
        }
    }

}
