***OnlineTaxi***  
Advanced programming project written in java.  
By Reyhaneh Khosravi.

**General Idea:**  
OnlineTaxi is an online taxi management, command-line interface program which allows users to sign up/ login, start and end trips and see the history of their trips. In this program drivers are generated randomly and passengers are the only users that can give inputs in the terminal. 

**Classes and interfaces:**

* **User**  
* **Passenger**  
* **Distance**  
* **Driver**  
* **Trip**  
* **Menu**  
* **CommandController**  
* **SystemManager**  
* **Main**

- **User:**  
  The class User is an abstract class that only has one protected variable by the type String called name. It has getter and setter for name and two constructors,one with zero arguments and the other with one argument (Name). Classes Passenger and Driver inherit the User class.  
  **Constructors:**  
* **User()**  
* **User(String name)**  
  **List of methods:**  
* **getName():** Getter for name which returns name.  
* **setName(String name):** Setter for name which returns nothing.


- **Passenger:**  
  The class Passenger is to manage the passenger’s info and list of trips. It has one integer variable called password which is private and the name variable which it inherits from the User class and a private ArrayList for the passenger’s trip’s history so that it doesn’t get combined with other passengers’ trip histories. It also has the password’s getter and setter, and a getter for the list of trips.  It has one constructor with two arguments which calls the super constructor and then adds its own features. This class imports the java.util.ArrayList to the trips list.   
  **Constructor:**  
* **Passenger(String name, integer password)**  
    
  **List of methods:**  
* **setPassword(integer password):** Setter for password which returns nothing.  
* **getPassword():** Getter for password which returns password.  
* **addTrip(Trip trip):** It adds the given trip to the trips arraylist. It returns the list of trips.


- **Distance:**  
  Distance is an interface. The Driver and Trip classes implement this interface to calculate the distance. It only has one method which is:   
* **getDistance(integer startX, integer startY, integer destinationX, integer destinationY).**  
    
- **Driver:**  
  This class also inherits the user class and it’s to manage the drivers. It has 5 variables which are private. It has their getters and setters. Variables: startX by the type of integer (the x factor of the start coordinate which the driver is in in the first place), startY by the type of integer ( the y factor of the destination coordinate which the driver is in in the first place), carModel by the type of String (The model of the driver’s car), a final static array by the type of Driver called drivers, and a boolean to save the status of the drivers called status(to see if the driver is available or not. It is initialized as true because at the start of the program all the drivers are available.).And it has 2 constructors. One with no arguments, just calling the super constructor and another that has 4 arguments. There is a static for generating 4 random drivers.

This class imports the java.util.Random to generate random coordinates for drivers.  
**Constructor:**

* **Driver()**  
* **Driver(String name, integer startX, integer startY, boolean status, String carModel)**

  **List of methods:**

* **getCarModel():** Getter for carModel. It returns carModel.  
* **getStatus():** Getter for status. It returns status.  
* **setStatus( boolean status):** Setter for status. It returns nothing.  
* **getStartX():** Getter for startX. It returns startX.  
* **setStartX(int startX):** Setter for startX. It returns nothing.  
* **getStartY():** Getter for startY. It returns startY.  
* **setStartY(int startY):** Setter for startY. It returns startY.  
* **getDistance(integer passengerStartX, integer passengerStartY, integer startX, integer destinationT):** The driver class implements the Distance class, so it overrides the getDistance method. In this method we calculate the shortest distance using the start position of the passenger and the start position of the driver via pythagoras. To use the pow and sqrt method, we call them by the Math class and use them in our formula. This method returns the distance.  
*  **findClosestDriver(integer passengerStartX, integer passengerStartY):** In this method, first we check if there is any driver available and if at least one is available, we compare the passenger’s position with the position of every available driver and find the closest available driver. When the driver is found, its status changes into false, which means it’s not available anymore because it’s going to be assigned to a trip. If there is no driver available we print a message saying that we found no driver, but if we do find the closest available driver, we print a message which contains the driver’s name, car model and start position. If the driver is available and decided, the method returns the driver by the Driver type. Because the drivers were defined as static, this method is static as well.

 


- **Trip:**  
  This class is to manage trips. It has 7 private variables: startX(the x coordinate of the start position of the trip, integer), startY(the y coordinate of the start position of the trip, integer), destinationX(the x coordinate of the destination position of the trip, integer), destinationY(the y coordinate of the destination position of the trip, integer), driver(the driver of the trip, Driver), cost(the cost of trip, double), isCancelled(the trip status to check if it is cancelled, boolean). It has two constructors, one with no argument and the other with 5 arguments. Getter and setters for  each private variable. This class has composition relationship with Driver class.  
    
  **Constructor:**  
* **Trip()**  
* **Trip(integer startX, integer startY, integer destinationX, integer destinationY, Driver driver)**


	**List of methods:**

* **getStartX():** Getter for startX, returns startX.  
* **getStartY():** Getter for startY, returns startY.  
* **setStartX(integer startX):** Setter for startX, returns nothing.  
* **setStartY(integer startY):** Setter for startY, returns nothing.  
* **getDestinationX():** Getter for destinationX, returns destinationX.  
* **getDestinationY():** Getter for destinationY, returns destinationY.  
* **setDestinationX(integer destinationX):** Setter for destinationX, returns nothing.  
* **setDestinationY(integer destinationY):** Setter for destinationY, returns nothing.   
* **getIsCancelled():** Getter for isCancelled, returns isCancelled.  
* **setCancelled(boolean isCancelled):** Setter for isCancelled, returns nothing.  
* **getDistance(integer startX, integer startY, integer destinationX, integer destinationY):** The trip class implements the Distance class, so it overrides the getDistance method and calculates the distance with the given arguments. It returns the distance.  
* **setCost():** Setter for cost. In this method, we call the getDistance method to calculate the distance of the trip. The distance multiple 3000 and at the end, 10000 is added to the final cost as the base cost. This method returns the cost.  
* **getCost():** Getter for cost, returns nothing.  
* **getDriver():** Getter for driver, returns driver.  
* **setDriver(Driver driver):** Setter for driver, returns nothing.




- **SystemManager:**  
  This class has 2 variables, one a menu by the type Menu, the other currentPassenger by the type passenger. The menu is to call the methods from the menu class, (showing different menus to the user at given situations) and currentPassenger is to track the passenger who logged in, so that they see the proper trip history, not someone else’s trip history. There are also getters and setters for menu and currentPassenger. Two ArrayLists are created, one for passengers and one for drivers.  
  This class imports java.util.\* for using Scanner and ArrayList classes.


**List of methods:**

* **getMenu():** Getter for menu, returns menu.  
* **setMenu(Menu menu):** Setter for menu, returns nothing.  
* **getCurrentPassenger():** Getter for currentPassenger, returns currentPassenger.  
* **setCurrentPassenger(Passenger currentPassenger):** Setter for currentPassenger, returns nothing.  
* **login(String name, integer password):** This method is for logging in. A boolean is defined so that if there is any passenger by the given name and password in the list, the found value is set as true. But if the account isn’t found, the found value is false. This is to prevent the program from terminating if login is the first choice of a user in the start of the program. The structure for finding the account is that we go through the passengers list and if the account exists in the list, we set it as the currentPassenger. Then the loggedInMenu is called to show the menu to the user.  
* **signUp(String name, integer password):** This method handles the sign-in actions. A passenger object from the Passenger class is created with the given name and password. The passenger is added to the passenger list so that after logging out, they can login again. The passenger is set as the currentPassenger and then the signedUpMenu from the menu class is called.  
* **createDriver(Trip trip):** In this method, the cost of the trip is shown to the passenger and the passenger is asked to wait so that a driver is found for the trip. An object from the Driver class is created which is called foundDriver and the result of the findClosestDriver from the Driver class, which is a driver, is stored in this variable. If the foundDriver variable isn’t null which means a driver has been found, the driver is set for the trip and it is added to the drivers list. Then the driverFoundMenu is called. Otherwise, when no driver is found, after the message that is printed from the findDriver method to iform the user that no driver has been found for the trip, the loggendInMenu is shown.


* **createTrip():** In this method, we get the input for the start and destination coordinates and check if they are valid and in a certain format. If the input is valid, we create a trip object from the Trip class and  set the coordinates as trip coordinates by calling setStartX, setStartY, setDestinationX and setDestinationY. We also set the trip status as not cancelled via the setCancelled method and we calculate the cost via setCost method. Which are all methods from the Trip class. Then we call the addTrip method via the currentPassenger object and add the trip to the currentPassenger’s trip history. At the end the createDriver method is called to find and set a driver for the trip.


* **getHistory():** We use this method to show the trip history to the user. At first we check that the currentPassenger is set and not null and then we get access to the list of trips of the currentPassenger. Then we form a loop to print details about every trip that the user took, except the ones that a driver wasn’t found for, therefore those trips weren’t started at all. If the user has taken no trips, a message is printed to inform the user that the history is empty and no trip is found. At the end, the loggedInMenu is called.


- **Menu:**  
  This class manages the menus that the user sees along the program. It has one private final variable for systemManager by the type of SystemManager. This class has a one argument constructor. This class has a composition relationship with the SystemManager class.  
  It imports java.util.InputMismatchExeptipn for exception handling and java.util.Scanner to read inputs.  
  **Constructor:**  
* **Menu(SystemManager systemManager)**


**List of methods:**

* **welcomeMenu():** In this method, we handle the invalid inputs by using try & catch. In the try body, we show the menu options when the user hasn't signed up or logged in. The options are to login, sign up or close the program. Choosing login, leads the user to loginMenu, choosing sign up leads to signUpMenu, and choosing to close the program, terminates the program. If the user enters anything rather than 1, 2 or 3, they get the error message and the welcomeMenu is shown again and they have to enter valid inputs.   
* **loggedInMenu():** This is a method for the state which the user has logged in. We have try & catch in this method as well.  At first, some options are shown and the user chooses one of them. If the user enters anything rather than 1, 2, 3 or 4, they see an error and the loggedInMenu is called again. The options are: Starting a trip, seeing the history of trips, logging out or closing the program. If they choose to start a trip, they see a message to enter their coordinates and the createTrip method which is a method from the SystemManage class is called. If they choose to see the history of their trips, the getHistory method from the SystemManager class is called. If they choose to log out, the welcomeMenu is called and if they choose to close the program, the program is terminated.


* **signedUpMenu():** We have try and catch in this method as well.This is a method for when the user has signed up. When this method is called, the user sees 3 options and if they enter any other number than 1,2 or 3, they see an error and this method is called again. The options are: Starting a new trip, logging out or closing the program, which are the same as in the loggedInMenu method.


* **loginMenu():** This method is for the time where the user tries to log in. There are several parts of this method to control the input such as checking if the input for name isn’t empty, contains only letters from alphabets and doesn't contain spaces. Also checks the input for password to be only 4 digits and no letters. If name and password are valid, the login method from the SystemManager class is called.


* **signUpMenu():** signUpMenu has the same structure as the loginMenul. It is called when the user tries to sign up. If the name and password are valid, the signUp method from the SystemManager class is called.


* **inTripMenu():** This is a method for when the passenger is on the trip. It shows the options the user has. It uses try & catch to check if the input is valid and if it’s not valid an error message would be shown to the user and this method is called again. The options are: Ending the trip and cancelling the trip. If the user chooses to end the trip, the endTripMenu is called. If they choose to cancel the trip, first we check that the trip history list isn’t empty and if it’s not, we mark this trip as cancelled, which we do by calling getCurrentPassenger, getTrips and setCancelled methods which are method from the SystemManager class. Basically, we call the current passenger and gain access to its trip list and mark this trip as cancelled. (Because when a trip is created, it is added to the trip history from the very start. So we have to distinguish the completed from the canceled trips.) We also get access to the drivers list via systemManager and set the status of this trip’s driver as true, Because the trip is cancelled and therefore, the driver is available for other trips. At the end, we call the loggedInMenu for the user to choose whether they want to start another trip, see trip history, etc.  
* **driverFoundMenu():** This method has 2 options and the input is checked via try & catch. Options: Starting the trip or cancelling it. If choosing start, a message is printed to indicate the drive is on their way. And then the inTripMenu is called for options while being on the trip. If choosing to cancel, the structure of cancelling is the same as this option in inTripMenu.

  \*  When the user chooses to start the trip and then cancel the trip when the trip has already begun, they have to pay the full price, but when they cancel the trip before starting it, there is no cost.

* **endTripMenu():** Shows a message to announce that the trip is over. Then calls the loggendInMenu for the user to decide what to do next.


- **CommandController:**

	This is a class that kinda runs the whole program. It only has one method called run.

**List of methods:**

* **run():** This is a static method, A systemManager object from SystemManager class is created and given to a menu object from Menu class that has been created as well. The setMenu method from the SystemManager class is called and the menu is given to systemManager. Then the welcomeMenu is called via the menu.  
    
- **Main:**  
  This class only has the main method and the program is started here.   
* **main(String\[ \] args):** A systemManager object is created and is given to a menu object that is created as well. The menu is given to systemManager via setManu method and then the run method of the class CommandController is called and the program begins.  
  
