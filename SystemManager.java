import java.util.*;

public class SystemManager {
    private Menu menu;
    private Passenger currentPassenger; // to track the passengers who logged in

    public Passenger getCurrentPassenger(){
        return currentPassenger;
    }

    public void setCurrentPassenger(Passenger currentPassenger){
        this.currentPassenger = currentPassenger;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    Scanner input = new Scanner(System.in);
    ArrayList<Passenger> passengers = new ArrayList<>();
    ArrayList<Driver> drivers = new ArrayList<>();

    public void login(String name, int password) {
        boolean found = false;
        for (Passenger p : passengers) {//checking tha passengers list to find the passenger by the given name and password.
            if (p.getName().equals(name) && p.getPassword() == password) {
                System.out.println("\nWelcome back " + name + "!");
                setCurrentPassenger(p);//to set the current passenger
                getMenu().loggedInMenu();
                found = true;
                break;
            }
        }
            if(!found){
                System.out.println("\nAccount not found.");
                getMenu().welcomeMenu();
            }
        }

    public void signUp(String name, int password) {
        Passenger passenger = new Passenger(name, password);
        passengers.add(passenger);
        setCurrentPassenger(passenger);//to set the current passenger
        System.out.println("\nWelcome " + name + "!");
        getMenu().signedUpMenu();
    }

    public void createDriver(Trip trip) {
        System.out.printf("\nThe cost would be: %.2f", trip.getCost());
        System.out.println("\nPlease wait while we find you the closest driver.\n...\n");
        Driver foundDriver = Driver.findClosestDriver(trip.getStartX(), trip.getStartY());
        if (foundDriver == null) {//means no driver wa found
            getMenu().loggedInMenu();
        } else {
            trip.setDriver(foundDriver);//assigning the driver to the trip
            drivers.add(foundDriver);// adding the driver to the drivers list
            getMenu().driverFoundMenu();

        }
    }


    public void createTrip() {
        String inputLine = input.nextLine().trim();//reading the whole line
        String[] parts = inputLine.split("\\s+"); //split by spaces
        if (parts.length != 2) {
            System.out.println("Invalid format. Please enter two integer coordinates like (1,2) (3,4).");
            createTrip();//retry if the input is wrong
            return;
        }
        try {
            String startStr = parts[0].replace("(", "").replace(")", "");
            String[] startCoords = startStr.split(",");
            int startX = Integer.parseInt(startCoords[0].trim());
            int startY = Integer.parseInt(startCoords[1].trim());
            //removing the () and , from the start coordinate

            String destStr = parts[1].replace("(", "").replace(")", "");
            String[] destCoords = destStr.split(",");
            int destX = Integer.parseInt(destCoords[0].trim());
            int destY = Integer.parseInt(destCoords[1].trim());
            //removing the () and , from the destination coordinate

            Trip trip = new Trip();
            trip.setCancelled(false);
            trip.setStartX(startX);
            trip.setStartY(startY);
            trip.setDestinationX(destX);
            trip.setDestinationY(destY);
            trip.setCost();
            currentPassenger.addTrip(trip);//adding the trip tp current passenger
            createDriver(trip);//finding and setting a driver for the trip.
        } catch (Exception e) {
            System.out.println("Invalid numbers or format. Example: (1,2) (3,4)");
            createTrip();//retry on error
        }
    }


    public void getHistory() {
        if(getCurrentPassenger() == null){
            return;
        }
        ArrayList<Trip> trips = currentPassenger.getTrips();//to get the current passenger's history, not the others.
        int count = 0;
        StringBuilder str = new StringBuilder();

        for (int i = 0; i < trips.size(); i++) {
            Trip t = trips.get(i);
            if (t.getDriver() == null) {
                continue; // Skip trips without drivers
            }
            count++;
            String status = t.getIsCancelled() ? "Cancelled" : "Completed";
            str.append(String.format("\n%d.\nDriver: %s\nStart position: ( %d , %d )\nDestination: ( %d , %d )\nStatus: %s\n",
                    count, t.getDriver().getName(), t.getStartX(), t.getStartY(),
                    t.getDestinationX(), t.getDestinationY(), status));
        }

        if (count == 0) {
            System.out.println("\nNo trip found.");
        } else {
            System.out.println(str);
        }
        menu.loggedInMenu();
    }
}