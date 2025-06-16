public class Trip {
    private int startX;
    private int startY;
    private int destinationX;
    private int destinationY;

    public int getStartX(){
        return startX;
    }

    public int getStartY(){
        return startY;
    }

    public void setStartX(int startX){
        this.startX = startX;
    }

    public void setStartY(int startY){
        this.startY = startY;
    }

    public int getDestinationX(){
        return destinationX;
    }

    public int getDestinationY(){
        return destinationY;
    }

    public void setDestinationX(int destinationX){
        this.destinationX = destinationX;
    }

    public void setDestinationY(int destinationY){
        this.destinationY = destinationY;
    }
    double rawDistance = (destinationX - startX)^2 + ((destinationY - startY)^2);
    double distance = Math.sqrt(rawDistance);
    public int cost(int distance){
        int Cost = distance * 3000;//each meter is cost 3000;
        Cost += 10000; //baseCost = 10000
        return Cost;
    }
}