import java.util.Scanner;
interface GPS {
    String getCurrentLocation();
    void updateLocation(String location);
}
abstract class Vehicle1 implements GPS {
    private String vehicleId;
    private String driverName;
    private double ratePerKm;
    private String currentLocation;
    private double additionalCharge;
    public void setVehicleId(String vehicleId) {
        this.vehicleId = vehicleId;
    }
    public String getVehicleId() {
        return vehicleId;
    }
    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }
    public String getDriverName() {
        return driverName;
    }
    public void setRatePerKm(double ratePerKm) {
        this.ratePerKm = ratePerKm;
    }
    public double getRatePerKm() {
        return ratePerKm;
    }
    public void setAdditionalCharge(double additionalCharge) {
        this.additionalCharge = additionalCharge;
    }
    public double getAdditionalCharge() {
        return additionalCharge;
    }
    public String getCurrentLocation() {
        return currentLocation;
    }
    public void updateLocation(String location) {
        this.currentLocation = location;
    }
    public void getVehicleDetails() {
        System.out.println("Vehicle ID: " + vehicleId);
        System.out.println("Driver Name: " + driverName);
        System.out.println("Rate per Km: " + ratePerKm);
        System.out.println("Additional Charge: " + additionalCharge);
        System.out.println("Current Location: " + currentLocation);
    }
    public abstract double calculateFare(double distance);
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Car1 car = new Car1();
        System.out.println("Enter Car Details:");
        System.out.print("Vehicle ID: ");
        car.setVehicleId(sc.nextLine());
        System.out.print("Driver Name: ");
        car.setDriverName(sc.nextLine());
        System.out.print("Rate per Km: ");
        car.setRatePerKm(sc.nextDouble());
        System.out.print("Additional Charge: ");
        car.setAdditionalCharge(sc.nextDouble());
        sc.nextLine();
        System.out.print("Current Location: ");
        car.updateLocation(sc.nextLine());
        System.out.print("Enter distance to travel: ");
        double carDistance = sc.nextDouble();
        System.out.println("\nCar Details:");
        car.getVehicleDetails();
        System.out.println("Fare: " + car.calculateFare(carDistance));
        sc.nextLine();
        Bike1 bike = new Bike1();
        System.out.println("\nEnter Bike Details:");
        System.out.print("Vehicle ID: ");
        bike.setVehicleId(sc.nextLine());
        System.out.print("Driver Name: ");
        bike.setDriverName(sc.nextLine());
        System.out.print("Rate per Km: ");
        bike.setRatePerKm(sc.nextDouble());
        System.out.print("Additional Charge: ");
        bike.setAdditionalCharge(sc.nextDouble());
        sc.nextLine();
        System.out.print("Current Location: ");
        bike.updateLocation(sc.nextLine());
        System.out.print("Enter distance to travel: ");
        double bikeDistance = sc.nextDouble();
        System.out.println("\nBike Details:");
        bike.getVehicleDetails();
        System.out.println("Fare: " + bike.calculateFare(bikeDistance));
        sc.nextLine();
        Auto1 auto = new Auto1();
        System.out.println("\nEnter Auto Details:");
        System.out.print("Vehicle ID: ");
        auto.setVehicleId(sc.nextLine());
        System.out.print("Driver Name: ");
        auto.setDriverName(sc.nextLine());
        System.out.print("Rate per Km: ");
        auto.setRatePerKm(sc.nextDouble());
        System.out.print("Additional Charge: ");
        auto.setAdditionalCharge(sc.nextDouble());
        sc.nextLine();
        System.out.print("Current Location: ");
        auto.updateLocation(sc.nextLine());
        System.out.print("Enter distance to travel: ");
        double autoDistance = sc.nextDouble();
        System.out.println("\nAuto Details:");
        auto.getVehicleDetails();
        System.out.println("Fare: " + auto.calculateFare(autoDistance));
    }
}
class Car1 extends Vehicle1 {
    public double calculateFare(double distance) {
        return distance * getRatePerKm() + getAdditionalCharge();
    }
}
class Bike1 extends Vehicle1 {
    public double calculateFare(double distance) {
        return distance * getRatePerKm() + getAdditionalCharge();
    }
}
class Auto1 extends Vehicle1 {
    public double calculateFare(double distance) {
        return distance * getRatePerKm() + getAdditionalCharge();
    }
}