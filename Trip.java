public class Trip implements Distance{
    private int startX;
    private int startY;
    private int destinationX;
    private int destinationY;
    private Driver driver;
    private double cost;
    private boolean isCancelled;


    public Trip() {
    }

    public Trip(int startX, int startY, int destinationX, int destinationY, Driver driver) {
        this.startX = startX;
        this.startY = startY;
        this.destinationX = destinationX;
        this.destinationY = destinationY;
        this.driver = driver;
    }

    public int getStartX() {
        return startX;
    }

    public int getStartY() {
        return startY;
    }

    public void setStartX(int startX) {
        this.startX = startX;
    }

    public void setStartY(int startY) {
        this.startY = startY;
    }

    public int getDestinationX() {
        return destinationX;
    }

    public int getDestinationY() {
        return destinationY;
    }

    public void setDestinationX(int destinationX) {
        this.destinationX = destinationX;
    }

    public void setDestinationY(int destinationY) {
        this.destinationY = destinationY;
    }

    public boolean getIsCancelled() {
        return isCancelled;
    }

    public void setCancelled(boolean isCancelled) {
        this.isCancelled = isCancelled;
    }

    @Override
    public double getDistance(int startX, int startY, int destinationX, int destinationY){
        double rawDistance = Math.pow(getDestinationX() - getStartX(), 2) + (Math.pow(getDestinationY() - getStartY(), 2));
        return Math.sqrt(rawDistance);
    }

    public void setCost() {
        double costing = getDistance(getStartX(), getStartY(), getDestinationX(), getDestinationY()) * 3000;//each meter is cost 3000;
        costing += 10000; //baseCost = 10000
        this.cost = costing;
    }

    public double getCost() {
        return cost;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }


}