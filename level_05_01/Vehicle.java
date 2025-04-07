import java.util.*;
class Vehicle {
    protected int maxSpeed;
    protected String fuelType;
    public Vehicle(int maxSpeed, String fuelType) {
        this.maxSpeed = maxSpeed;
        this.fuelType = fuelType;
    }
    public void displayInfo() {
        System.out.print("Car details");
        System.out.println("Max Speed: " + maxSpeed + " km/h");
        System.out.println("Fuel Type: " + fuelType);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Car details (maxSpeed, fuelType, seatCapacity): ");
        int carSpeed = scanner.nextInt();
        scanner.nextLine();
        String carFuel = scanner.next();
        int seatCapacity = scanner.nextInt();
        Vehicle car = new Car(carSpeed, carFuel, seatCapacity);
        System.out.print("Enter Truck details (maxSpeed and fuelType): ");
        int truckSpeed = scanner.nextInt();
        String truckFuel = scanner.next();
        Vehicle truck = new Truck(truckSpeed, truckFuel);
        System.out.print("Enter Motorcycle details (maxSpeed and fuelType): ");
        int bikeSpeed = scanner.nextInt();
        String bikeFuel = scanner.next();
        Vehicle motorcycle = new Motorcycle(bikeSpeed, bikeFuel);
        System.out.println("\nVehicle Details:");
        Vehicle[] vehicles = {car, truck, motorcycle};
        for (Vehicle v : vehicles) {
            v.displayInfo();
            System.out.println(" ");
        }
    }
}
class Car extends Vehicle {
    private int seatCapacity;
    Car(int maxSpeed, String fuelType, int seatCapacity) {
        super(maxSpeed, fuelType);
        this.seatCapacity = seatCapacity;
    }
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Seat Capacity: " + seatCapacity);
    }
}
class Truck extends Vehicle {
    Truck(int maxSpeed, String fuelType) {
        super(maxSpeed, fuelType);
    }
    @Override
    public void displayInfo() {
        super.displayInfo();
    }
}
class Motorcycle extends Vehicle {
    Motorcycle(int maxSpeed, String fuelType) {
        super(maxSpeed, fuelType);
    }
    @Override
    public void displayInfo() {
        super.displayInfo();
    }
}