
import java.util.ArrayList;

public class SystemManager {
    ArrayList<Passenger> passengers = new ArrayList<>();
    public void login(String name, int password){
        Passenger passenger = new Passenger(name, password);
        for(int i = 0; i < passengers.size(); i++){
            Passenger p = passengers.get(i);
            if(p.getName().equals(name)){
                passenger = p;
                System.err.println("Welcome back " + name + "!");
            }
            else{
                System.out.println("The account not found.");
            }
        }
    }
    public void signUp(String name, int password){
        Passenger passenger = new Passenger(name, password);
        passengers.add(passenger);
        System.err.println("Welcome " + name + "!");
    }
}