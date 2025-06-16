import java.util.*;
public class Main {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.printf("Welcome!\n1.Login\n2.Sign up");
        int choose = input.nextInt();
        Passenger passenger = new Passenger();
        if(choose == 1){
            System.out.println("Please enter your name: ");
            String name = input.nextLine();
            System.out.println("Please enter your password: ");
            int password = input.nextInt();
            passenger.Login(name, password);
        }
        else if(choose == 2){
            System.out.println("Please enter your name: ");
            String name = input.nextLine();
            System.out.println("Please enter a password: ");
            int password = input.nextInt();
            passenger.SignUp(name, password);
        }
        else {
            System.out.println("Invalid input. Choose between 1 or 2.");
        }
    }
    }