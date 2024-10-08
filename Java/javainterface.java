// Interface declaration
interface Vehicle {
    // Method to start the vehicle
    void start();
    
    // Method to stop the vehicle
    void stop();
    
    // Method to check the fuel level
    int checkFuelLevel();
    
    // Method to get the vehicle's details
    String getDetails();
}

// Implementing the Car class with Vehicle interface
class Car implements Vehicle {
    private String model;
    private String brand;
    private int fuelLevel;
    
    public Car(String model, String brand, int fuelLevel) {
        this.model = model;
        this.brand = brand;
        this.fuelLevel = fuelLevel;
    }

    // Method to start the car
    @Override
    public void start() {
        System.out.println("Car is starting...");
    }
    
    // Method to stop the car
    @Override
    public void stop() {
        System.out.println("Car is stopping...");
    }
    
    // Method to check the fuel level in the car
    @Override
    public int checkFuelLevel() {
        return fuelLevel;
    }
    
    // Method to return car details
    @Override
    public String getDetails() {
        return "Car Model: " + model + ", Brand: " + brand + ", Fuel Level: " + fuelLevel;
    }
    
    // Specific method for Car to open the trunk
    public void openTrunk() {
        System.out.println("Opening the trunk of the car...");
    }
}

// Implementing the Bike class with Vehicle interface
class Bike implements Vehicle {
    private String type;
    private String brand;
    private int fuelLevel;
    
    public Bike(String type, String brand, int fuelLevel) {
        this.type = type;
        this.brand = brand;
        this.fuelLevel = fuelLevel;
    }

    // Method to start the bike
    @Override
    public void start() {
        System.out.println("Bike is starting...");
    }
    
    // Method to stop the bike
    @Override
    public void stop() {
        System.out.println("Bike is stopping...");
    }
    
    // Method to check the fuel level in the bike
    @Override
    public int checkFuelLevel() {
        return fuelLevel;
    }
    
    // Method to return bike details
    @Override
    public String getDetails() {
        return "Bike Type: " + type + ", Brand: " + brand + ", Fuel Level: " + fuelLevel;
    }
    
    // Specific method for Bike to put on helmet
    public void wearHelmet() {
        System.out.println("Wearing helmet...");
    }
}

// Implementing the Truck class with Vehicle interface
class Truck implements Vehicle {
    private String model;
    private String brand;
    private int fuelLevel;
    private int loadCapacity; // specific to trucks
    
    public Truck(String model, String brand, int fuelLevel, int loadCapacity) {
        this.model = model;
        this.brand = brand;
        this.fuelLevel = fuelLevel;
        this.loadCapacity = loadCapacity;
    }

    // Method to start the truck
    @Override
    public void start() {
        System.out.println("Truck is starting...");
    }
    
    // Method to stop the truck
    @Override
    public void stop() {
        System.out.println("Truck is stopping...");
    }
    
    // Method to check the fuel level in the truck
    @Override
    public int checkFuelLevel() {
        return fuelLevel;
    }
    
    // Method to return truck details
    @Override
    public String getDetails() {
        return "Truck Model: " + model + ", Brand: " + brand + ", Fuel Level: " + fuelLevel + ", Load Capacity: " + loadCapacity + " tons";
    }
    
    // Specific method for Truck to load cargo
    public void loadCargo(int load) {
        if (load <= loadCapacity) {
            System.out.println("Loading cargo of " + load + " tons into the truck.");
        } else {
            System.out.println("Cannot load " + load + " tons. Max capacity is " + loadCapacity + " tons.");
        }
    }
}

// Abstract class Mechanic (Demonstrating abstraction with inheritance)
abstract class Mechanic {
    // Abstract method to perform vehicle service
    abstract void serviceVehicle(Vehicle vehicle);

    // Common method for all mechanics
    public void checkTires() {
        System.out.println("Checking tires...");
    }
}

// CarMechanic class extending Mechanic class
class CarMechanic extends Mechanic {
    @Override
    public void serviceVehicle(Vehicle vehicle) {
        System.out.println("Servicing the car...");
        vehicle.start();
        vehicle.checkFuelLevel();
        vehicle.stop();
        System.out.println("Car service completed.");
    }
    
    // Specific method for car mechanic
    public void changeOil() {
        System.out.println("Changing car oil...");
    }
}

// TruckMechanic class extending Mechanic class
class TruckMechanic extends Mechanic {
    @Override
    public void serviceVehicle(Vehicle vehicle) {
        System.out.println("Servicing the truck...");
        vehicle.start();
        vehicle.checkFuelLevel();
        vehicle.stop();
        System.out.println("Truck service completed.");
    }
    
    // Specific method for truck mechanic
    public void inspectLoadCapacity() {
        System.out.println("Inspecting truck load capacity...");
    }
}

// Main class to demonstrate the interface implementation
public class Main {
    public static void main(String[] args) {
        // Create car, bike, and truck objects
        Vehicle myCar = new Car("Sedan", "Toyota", 70);
        Vehicle myBike = new Bike("Sports", "Yamaha", 30);
        Vehicle myTruck = new Truck("Heavy Duty", "Ford", 80, 10);

        // Interact with each vehicle
        myCar.start();
        System.out.println(myCar.getDetails());
        myCar.stop();
        ((Car)myCar).openTrunk(); // Casting to Car to access specific method

        System.out.println("---------------------------");

        myBike.start();
        System.out.println(myBike.getDetails());
        myBike.stop();
        ((Bike)myBike).wearHelmet(); // Casting to Bike to access specific method

        System.out.println("---------------------------");

        myTruck.start();
        System.out.println(myTruck.getDetails());
        myTruck.stop();
        ((Truck)myTruck).loadCargo(8); // Casting to Truck to access specific method

        System.out.println("---------------------------");

        // Using mechanics to service vehicles
        CarMechanic carMechanic = new CarMechanic();
        TruckMechanic truckMechanic = new TruckMechanic();

        carMechanic.serviceVehicle(myCar); // Service the car
        truckMechanic.serviceVehicle(myTruck); // Service the truck

        carMechanic.changeOil(); // Car mechanic changing oil
        truckMechanic.inspectLoadCapacity(); // Truck mechanic inspecting load capacity

        System.out.println("---------------------------");

        // Demonstrating inheritance with an array of vehicles
        Vehicle[] vehicles = {myCar, myBike, myTruck};
        for (Vehicle v : vehicles) {
            v.start();
            System.out.println(v.getDetails());
            v.stop();
        }

        // Check for tire inspection (common method for all mechanics)
        carMechanic.checkTires();
        truckMechanic.checkTires();
    }
}
