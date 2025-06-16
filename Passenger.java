public class Passenger extends User{
    private int password;
    public void Login(String name, int password){
        this.name = name;
        this.password = password;
    }
    public void SignUp(String name, int password){
        this.name = name;
        this.password = password;
    }
}