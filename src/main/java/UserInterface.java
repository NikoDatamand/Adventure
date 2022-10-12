import org.w3c.dom.ranges.Range;

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
                
                After a long day of work, you get awfully drunk with your colleagues.
                Looking at the clock, you decide to leave the bar and head home.
                But dragging your drunk corpse of a body around the city at night,
                seems more difficult than it seems...
                
                COMMANDS:
                                                
                go (north, south, east, west)
                look (in current room)
                take / drop (item)
                inventory (see items)
                equip / unequip (weapon)
                attack (with equipped weapon)
                eat (food in inventory)
                health (see your health)
                help (print this list of commands)
                exit
                """);
        System.out.println(adventure.getPlayer().getCurrentRoom());
        handleInput();
    }
    public void handleInput(){
        while (true) {
            System.out.println(" ");
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

                case "equip" -> {
                    boolean itemFound = adventure.getPlayer().doesItemExist(command[1]);
                    if (itemFound){
                        Weapon weaponToBeEquipped = adventure.getPlayer().searchWeaponInInventory(command[1]);
                        if (weaponToBeEquipped != null) {
                            adventure.getPlayer().equipWeapon(weaponToBeEquipped);
                            System.out.println("You've equipped " + command[1]);
                        } else {
                            System.out.println(command[1] + " isn't a weapon!");
                        }
                    }else {
                        System.out.println(command[1] + " is not in your inventory.");
                    }
                }

                case "unequip" -> {
                    boolean itemFound = adventure.getPlayer().doesItemExist(command[1]);
                    if (itemFound){
                        Weapon weaponToBeUnEquipped = adventure.getPlayer().searchWeaponInInventory(command[1]);
                        if (weaponToBeUnEquipped == adventure.getPlayer().getEquippedWeapon()) {
                            adventure.getPlayer().unEquipWeapon(weaponToBeUnEquipped);
                            System.out.println("You've unequipped " + command[1]);
                        } else {
                            System.out.println(command[1] + " isn't equipped");
                        }
                    }else {
                        System.out.println(command[1] + " is not in your inventory.");
                    }
                }

                case "attack" -> {
                        Room currentRoom = adventure.getPlayer().getCurrentRoom();
                        Enemy enemy =  adventure.getPlayer().getCurrentRoom().searchEnemy(command[1]);
                        if (enemy != null) {
                            if (adventure.getPlayer().getEquippedWeapon() != null) {
                                Weapon attackWeapon = adventure.getPlayer().getEquippedWeapon();
                                boolean isRangedWeapon = adventure.getPlayer().isRangedWeapon(attackWeapon.getName());
                                if (isRangedWeapon) {
                                    RangedWeapon rangedWeaponInUse = adventure.getPlayer().useRangedWeapon(attackWeapon.getName());
                                    if (rangedWeaponInUse.getUses() > 0) {
                                        rangedWeaponInUse.rangedWeaponUsed();
                                        enemy.changeHealth(attackWeapon.getDamage());
                                        System.out.println("You attack with " + attackWeapon.getName() + " You have " + rangedWeaponInUse.getUses() + " ammo left.");
                                        if (enemy.getHealth() <= 0) {
                                            currentRoom.removeEnemiesFromRoom(enemy);
                                        } else {
                                            System.out.println(enemy);
                                        }
                                    } else if (rangedWeaponInUse.getUses() <= 0) {
                                        System.out.println("You're out of ammo... Equip another weapon or flee!");
                                    }
                                } else {
                                    System.out.println("You attack with " + attackWeapon.getName());
                                    enemy.changeHealth(attackWeapon.getDamage());
                                    if (enemy.getHealth() <= 0) {
                                        currentRoom.removeEnemiesFromRoom(enemy);
                                    } else {
                                        System.out.println(enemy);
                                    }
                                }
                            } else {
                                System.out.println("You haven't equipped a weapon!!!");
                            }
                            if (enemy.getHealth() > 0) {
                                int enemyDamage = enemy.attackPlayer();
                                adventure.getPlayer().changeHealth(enemyDamage);
                            }
                        } else {
                            System.out.println("here is no enemies by that description.");
                        }
                }

                case "inventory", "inv" -> System.out.println(adventure.getPlayer().printInventory());

                case "look" -> System.out.println(adventure.getPlayer().getCurrentRoom());
                case "health" -> System.out.println(adventure.getPlayer().getHealth());
                case "help" ->    System.out.println("""
              
                COMMANDS:
                                                
                go (north, south, east, west)
                look (in current room)
                take / drop (item)
                inventory (see items)
                equip / unequip (weapon)
                attack (with equipped weapon)
                eat (food in inventory)
                health (see your health)
                help (print this list of commands)
                exit
                """);


                case "exit" -> System.exit(0);
                default-> System.out.println("Invalid request, try again.");
            }
        }
    }

}
