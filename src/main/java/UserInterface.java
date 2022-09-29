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
            String[] command = action.split(" ");

            switch (command[0]) {
                case "go" ->{
                    switch ((command[1])) {
                        case "north", "n" -> {
                            if (adventure.player.getCurrentRoom().getNorth() != null) {
                                adventure.player.setCurrentRoom(adventure.player.getCurrentRoom().getNorth());
                                System.out.println("going north");
                                System.out.println(adventure.player.getCurrentRoom());
                            } else if (adventure.player.getCurrentRoom().getNorth() == null) {
                                System.out.println("You can't go that way!");
                            }
                        }

                        case "south", "s" -> {
                            if (adventure.player.getCurrentRoom().getSouth() != null) {
                                adventure.player.setCurrentRoom(adventure.player.getCurrentRoom().getSouth());
                                System.out.println("going south");
                                System.out.println(adventure.player.getCurrentRoom());
                            } else if (adventure.player.getCurrentRoom().getSouth() == null) {
                                System.out.println("You can't go that way!");
                            }
                        }

                        case "east", "e" -> {
                            if (adventure.player.getCurrentRoom().getEast() != null) {
                                adventure.player.setCurrentRoom(adventure.player.getCurrentRoom().getEast());
                                System.out.println("going east");
                                System.out.println(adventure.player.getCurrentRoom());
                            } else if (adventure.player.getCurrentRoom().getEast() == null) {
                                System.out.println("You can't go that way!");
                            }
                        }

                        case "west", "w" -> {
                            if (adventure.player.getCurrentRoom().getWest() != null) {
                                adventure.player.setCurrentRoom(adventure.player.getCurrentRoom().getWest());
                                System.out.println("going west");
                                System.out.println(adventure.player.getCurrentRoom());
                            } else if (adventure.player.getCurrentRoom().getWest() == null) {
                                System.out.println("You can't go that way!");
                            }
                        }
                    }

                }
                case "take" -> {
                    Item requiredItem = adventure.player.getCurrentRoom().searchItem(command[1]);
                    if (requiredItem != null) {
                        adventure.player.addItemToInventory(requiredItem);
                        adventure.player.getCurrentRoom().deleteItemFromRoom(requiredItem);
                        System.out.println("You've taken " + command[1]);
                     } else {
                        System.out.println(command[1] + " couldn't be found in this room");
                    }
                }

                case "inventory" -> System.out.println(adventure.player.printInventory());


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
