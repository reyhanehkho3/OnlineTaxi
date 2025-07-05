import java.util.ArrayList;

public class Passenger extends User {
    private int password;
    private ArrayList<Trip> trips = new ArrayList<>();//to keep every individual's trip history for themselves.

    public Passenger(String name, int password) {
        super(name);
        this.password = password;
    }

    public void setPassword(int password) {
        this.password = password;
    }

    public int getPassword() {
        return password;
    }

    public void addTrip(Trip trip){
        trips.add(trip);
    }//to add the trip to the list of trips

    public ArrayList<Trip> getTrips(){
        return trips;
    }
}