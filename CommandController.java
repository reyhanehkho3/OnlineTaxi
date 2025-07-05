public class CommandController {
    public static void run() {
        SystemManager systemManager = new SystemManager();
        Menu menu = new Menu(systemManager);
        systemManager.setMenu(menu);
        menu.welcomeMenu();
    }
}
