import java.util.Random;
public class Driver extends User implements Distance {
    private int startX;
    private int startY;
    private String carModel;
    private static final Driver[] drivers;//to keep the drivers in an array
    private boolean status = true;//true means available

    static {
        Random rand = new Random();
        int n1 = rand.nextInt(100) + 1;//random number from 1 to 100
        int n2 = rand.nextInt(100) + 1;
        int n3 = rand.nextInt(100) + 1;
        int n4 = rand.nextInt(100) + 1;
        int n5 = rand.nextInt(100) + 1;
        int n6 = rand.nextInt(100) + 1;
        int n7 = rand.nextInt(100) + 1;
        int n8 = rand.nextInt(100) + 1;
        drivers = new Driver[4];
        drivers[0] = new Driver("Ahmad Kiani", n1, n2, true, "Pride");
        drivers[1] = new Driver("Reza Sadeghi Nia", n3, n4, true, "Neissan");
        drivers[2] = new Driver("Sedigheh Sheikhani", n5, n6, true, "BMW");
        drivers[3] = new Driver("Arman Azadi Far", n7, n8, true, "Pejo");
    }//generating random drivers

    public Driver() {
        super();
    }

    public Driver(String name, int startX, int startY, boolean status, String carModel) {
        super(name);
        this.startX = startX;
        this.startY = startY;
        this.status = status;
        this.carModel = carModel;
    }

    public int getStartX() {
        return startX;
    }

    public String getCarModel() {
        return carModel;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void setStartX(int startX) {
        this.startX = startX;
    }

    public int getStartY() {
        return startY;
    }

    public void setStartY(int startY) {
        this.startY = startY;
    }

    @Override
    public double getDistance(int startX, int startY, int passengerStartX, int passengerStartY) {
        double rawDistance = Math.pow(startX - passengerStartX, 2) + (Math.pow(startY - passengerStartY, 2));
        return Math.sqrt(rawDistance);
    }//calculating the shortest distance by pythagoras


    public static Driver findClosestDriver(int passengerStartX, int passengerStartY) {
        int index = 0;
        double min = Double.MAX_VALUE;
        boolean atLeastOneAvailable = false;

        for(int i = 0; i < 4; i++) {
                if (drivers[i].getStatus()) {
                    atLeastOneAvailable = true;
                    double distance = drivers[i].getDistance(passengerStartX, passengerStartY, drivers[index].getStartX(), drivers[index].getStartY());
                    if (distance <= min) {
                        min = distance;
                        index = i;
                    }//to check at least one driver is available. And if there is any driver availble then find th nearest one by comparing the distances between driver and passenger.
                }
        }
            if (atLeastOneAvailable) {
                Driver closestDriver = drivers[index];
                System.out.println("We found you a driver!\nYour driver's name: " + drivers[index].getName());
                System.out.println("\nCar model: " + drivers[index].getCarModel());
                System.out.println("\nStart position: ( " + drivers[index].getStartX() + " , " + drivers[index].getStartY() + " ).");
                drivers[index].setStatus(false);//the driver which is assigned to the trip is now unavailable for other trips unless the passenger cancels the trip.
                return closestDriver;
            } else {
                System.out.println("Sorry. We couldn't find you a driver");
                return null;
            }//if there is no driver available
    }


}