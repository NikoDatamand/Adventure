import java.util.Scanner;
public class UserInterface {
    private Adventure adventure;
    private Scanner sc;

    public UserInterface(){
        adventure = new Adventure();
        sc = new Scanner(System.in);
    }
    public void start(){
        System.out.println("""
                
                """);
        System.out.println(adventure.getPlayer().getCurrentRoom());
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
                            boolean goingNorth = adventure.goNorth();
                            if (goingNorth) {
                                System.out.println("going north");
                                System.out.println(adventure.getPlayer().getCurrentRoom());
                            } else  {
                                System.out.println("You can't go that way!");
                            }
                        }

                        case "south", "s" -> {
                            boolean goingSouth = adventure.goSouth();
                            if (goingSouth) {
                                System.out.println("going south");
                                System.out.println(adventure.getPlayer().getCurrentRoom());
                            } else {
                                System.out.println("You can't go that way!");
                            }
                        }

                        case "east", "e" -> {
                            boolean goingEast = adventure.goEast();
                            if (goingEast) {
                                System.out.println("going east");
                                System.out.println(adventure.getPlayer().getCurrentRoom());
                            } else {
                                System.out.println("You can't go that way!");
                            }
                        }

                        case "west", "w" -> {
                            boolean goingWest = adventure.goWest();
                            if (goingWest) {
                                System.out.println("going west");
                                System.out.println(adventure.getPlayer().getCurrentRoom());
                            } else if (adventure.getPlayer().getCurrentRoom().getWest() == null) {
                                System.out.println("You can't go that way!");
                            }
                        }
                    }

                }
                case "take" -> {
                    boolean itemTaken = adventure.getPlayer().takeItem(command[1]);
                    if (itemTaken) {
                        System.out.println("You've taken " + command[1]);
                     } else {
                        System.out.println(command[1] + " couldn't be found in this room");
                    }
                }

                case "drop" -> {
                    boolean itemDropped = adventure.getPlayer().dropItem(command[1]);
                    if (itemDropped){
                        System.out.println("you dropped " + command[1]);
                    }else {
                        System.out.println(command[1] + " is not in your inventory.");
                    }
                }

                case "eat" -> {
                    boolean itemFound = adventure.getPlayer().doesItemExist(command[1]);
                    if (itemFound){
                        Food foodToBeEaten = adventure.getPlayer().searchFoodInInventory(command[1]);
                        if (foodToBeEaten != null) {
                            adventure.getPlayer().changeHealth(foodToBeEaten.getHealthPoints());
                            adventure.getPlayer().eatFood(command[1]);
                            System.out.println("You've eaten " + command[1]);
                        } else {
                            System.out.println(command[1] + " isn't food!");
                        }
                    }else {
                        System.out.println(command[1] + " is not in your inventory.");
                    }

                }

                case "inventory", "inv" -> System.out.println(adventure.getPlayer().printInventory());

                case "look" -> System.out.println(adventure.getPlayer().getCurrentRoom());
                case "health" -> System.out.println(adventure.getPlayer().getHealth());
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
