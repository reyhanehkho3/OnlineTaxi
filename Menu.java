import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    private final SystemManager systemManager;
    Scanner input = new Scanner(System.in);

    public Menu(SystemManager systemManager){//constructor with 1 argument
        this.systemManager = systemManager;
    }
    public void welcomeMenu() {
        System.out.println("**Welcome!**\nPlease choose an option: \n1.Login\n2.Sign up\n3.Close the program");
        try {
            int choice = input.nextInt();
            input.nextLine(); // clear buffer
            switch (choice) {
                case (1):
                    loginMenu();
                    break;
                case (2):
                    signUpMenu();
                    break;
                case (3):
                    System.exit(0);
                    break;
                default:
                    System.out.println("\nPlease enter a number between 1, 2 or 3.\n");
                    welcomeMenu(); //calling again to have a valid input
                    break;
            }
        }
        catch (InputMismatchException e){
            System.out.println("\nPlease enter a number between 1, 2 or 3.\n");
            input.nextLine(); // to clear the invalid input
            welcomeMenu();
        }//exception handling
    }

    public void loggedInMenu() {
        System.out.println("\nPlease choose one of these options:");
        System.out.println("1.Start a new trip");
        System.out.println("2.See the history of your trips");
        System.out.println("3.Log out");
        System.out.println("4.Close the program");
        try {
            int choice = input.nextInt();
            input.nextLine(); // clear buffer
            switch (choice) {
                case (1):
                    System.out.println("\nPlease enter your start and destination positions (integer) in the format (x1,y1) (x2,y2):");
                    systemManager.createTrip();
                    break;
                case (2):
                    systemManager.getHistory();
                    break;
                case (3):
                    System.out.println("Alright!");
                    welcomeMenu();;
                    break;
                case (4):
                    System.exit(0);//terminating the program
                    break;
                default:
                    System.out.println("Please enter a number between 1, 2, 3, or 4.");
                    loggedInMenu();
                    break;
            }
        }
        catch(InputMismatchException e){
            System.out.println("Please enter a number between 1, 2, 3, or 4.");
            input.nextLine();
            loggedInMenu();
        }
    }

    public void signedUpMenu() {
        System.out.println("\nPlease choose one of these options:");
        System.out.println("1.Start a new trip");
        System.out.println("2.Log out");
        System.out.println("3.Close the program");
        try {
            int choice = input.nextInt();
            input.nextLine(); // clear buffer
            switch (choice) {
                case (1):
                    System.out.println("\nPlease enter your start and destination positions (integer) in the format (x1,y1) (x2,y2):");
                    systemManager.createTrip();
                    break;
                case (2):
                    System.out.println("\nAlright!");
                    welcomeMenu();
                    break;
                case (3):
                    System.exit(0);
                    break;
                default:
                    System.out.println("Please enter a number between 1, 2 or 3.");
                    signedUpMenu();
                    break;
            }
        }
        catch (InputMismatchException e){
            System.out.println("Please enter a number between 1, 2 or 3.");
            input.nextLine();
            signedUpMenu();
        }
    }

    public void loginMenu() {
        System.out.println("\nPlease enter your name: ");
        String name = input.nextLine().trim();
        if(name.isEmpty()){
            System.out.println("Name cannot be empty. Please try again.");
            loginMenu();
            return;
        }
        if(!name.matches("[a-zA-Z]+")){
            System.out.println("Invalid name. Only alphabetic characters and spaces are not allowed.");
            loginMenu();
            return;
        }

        System.out.println("Please enter your password: ");
        try {
            String passwordStr = input.nextLine().trim();
            int password = Integer.parseInt(passwordStr);
            if(password < 1000 || password > 9999){
                throw new IllegalArgumentException("Password must be a 4-digit integer.");
            }
            systemManager.login(name, password);
        }
        catch (NumberFormatException e){
            System.out.println("Invalid input. Please enter a valid integer for the password.");
            loginMenu();
        }
        catch (IllegalArgumentException e){
            System.out.println(e.getMessage());//printing the custom error message
            loginMenu();
        }
    }

    public void signUpMenu() {
        System.out.println("\nPlease enter your name: ");
        String name = input.nextLine().trim();
        if(name.isEmpty()) {
            System.out.println("Name cannot be empty. Please try again.");
            signUpMenu();
            return;
        }
        if(!name.matches("[a-zA-Z]+")){
            System.out.println("Invalid name. Only alphabetic characters are allowed and spaces are not.");
            signUpMenu();
            return;
        }
        System.out.println("Please enter a password:\nYour password must consist of only 4 integer numbers. ");
        try {
            String passwordStr = input.nextLine().trim();
            int password = Integer.parseInt(passwordStr);
            if(password < 1000 || password > 9999){
                throw new IllegalArgumentException("Password must be a 4-digit integer.");
            }
            systemManager.signUp(name, password);
        }
        catch (NumberFormatException e){
            System.out.println("Invalid input. Please enter a valid integer for the password.");
            input.nextLine();
            signUpMenu();//retrying the sign-up process
        }
        catch (IllegalArgumentException e){
            System.out.println(e.getMessage());//printing the custom error message
            signUpMenu();//retrying the sign-up process
        }
    }


    public void endTripMenu() {
        System.out.println("\nHope you enjoyed your trip!");
        loggedInMenu();
    }

    public void inTripMenu() {
        System.out.println("\nPlease choose one of these options:");
        System.out.println("1.End trip");
        System.out.println("2.Cancel trip (Attention! Because you started the trip you have to pay the full price anyways.\nThe canceled trips are added to your trip history as well.)");
        try {
            int choice = input.nextInt();
            input.nextLine(); // clear buffer
            switch (choice) {
                case (1):
                    endTripMenu();
                    break;
                case (2):
                    if(!systemManager.getCurrentPassenger().getTrips().isEmpty()){//checking that the trip history isn't empty.
                        systemManager.getCurrentPassenger().getTrips().get(systemManager.getCurrentPassenger().getTrips().size() - 1).setCancelled(true);//marking the trip as cancelled
                        systemManager.drivers.get(systemManager.drivers.size() -1).setStatus(true);//marking drive as available
                    }
                    loggedInMenu();
                    break;
                default:
                    System.out.println("Please enter a number between 1 or 2.");
                    inTripMenu();
                    break;
            }
        }
        catch (InputMismatchException e){
            System.out.println("Please enter a number between 1 or 2.");
            input.nextLine();
            inTripMenu();
        }
    }

    public void driverFoundMenu() {
        System.out.println("\nPlease choose one of these options:");
        System.out.println("1.Start trip");
        System.out.println("2.Cancel trip (No cost)");
        try {
            int choice = input.nextInt();
            input.nextLine(); // clear buffer
            switch (choice) {
                case (1):
                    System.out.println("\nYour driver will be there in a few minutes! \n... \nHave a nice trip!\n...");
                    inTripMenu();
                    break;
                case (2):
                    if (!systemManager.getCurrentPassenger().getTrips().isEmpty()) {
                        systemManager.getCurrentPassenger().getTrips().get(systemManager.getCurrentPassenger().getTrips().size() - 1).setCancelled(true);
                        systemManager.drivers.get(systemManager.drivers.size() -1).setStatus(true);
                    }
                    System.out.println("\nAlright!\nThe canceled trips are added to your history as well.");
                    loggedInMenu();
                    break;
                default:
                    System.out.println("Please enter a number between 1 or 2.");
                    driverFoundMenu();
                    break;
            }
        }
        catch (InputMismatchException e){
            System.out.println("Please enter a number between 1 or 2.");
            input.nextLine();
            driverFoundMenu();
        }
    }
}
