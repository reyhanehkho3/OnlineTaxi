public class Main {
    public static void main(String[] args) {
        SystemManager systemManager = new SystemManager();
        Menu menu = new Menu(systemManager);
        systemManager.setMenu(menu);
            CommandController.run();
    }
}