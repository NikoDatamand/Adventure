import java.util.Scanner;
public class UserInterface {

    Scanner sc = new Scanner(System.in);

    public void handleInput(){
        System.out.println("What do you want to do?");
        String action = sc.nextLine();

        switch (action){
            case "go north":
                System.out.println("going north");
                break;

            case "go south":
                System.out.println("going south");
                break;

            case "go east":
                System.out.println("going east");
                break;

            case "go west":
                System.out.println("going west");
                break;

            case "look":
                System.out.println("looking around");
                break;
        }
    }

}
