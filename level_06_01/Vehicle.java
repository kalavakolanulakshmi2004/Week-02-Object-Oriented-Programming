import java.util.Scanner;
interface Insurable {
    double calculateInsurance();
    String getInsuranceDetails();
}
abstract class Vehicle implements Insurable {
    private String vehicleNumber;
    private String type;
    private double rentalRate;
    protected double insurancePercent;
    public String getVehicleNumber() {
        return vehicleNumber;
    }
    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public double getRentalRate() {
        return rentalRate;
    }
    public void setRentalRate(double rentalRate) {
        this.rentalRate = rentalRate;
    }
    public void setInsurancePercent(double insurancePercent) {
        this.insurancePercent = insurancePercent;
    }
    public abstract double calculateRentalCost(int days);
    public void displayDetails(int days) {
        double rentalCost = calculateRentalCost(days);
        double insurance = calculateInsurance();
        System.out.println("Vehicle No: " + vehicleNumber + ", Type: " + type + ", Rate/Day: " + rentalRate + ", Days: " + days + ", Rental Cost: " + rentalCost + ", Insurance: " + insurance + ", Total: " + (rentalCost + insurance));
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Vehicle[] vehicles = new Vehicle[3];
        Car car = new Car();
        System.out.println("Enter details for Car:");
        System.out.print("Vehicle Number: ");
        car.setVehicleNumber(sc.nextLine());
        System.out.print("Type: ");
        car.setType(sc.nextLine());
        System.out.print("Rental Rate per Day: ");
        car.setRentalRate(sc.nextDouble());
        System.out.print("Insurance Percent: ");
        car.setInsurancePercent(sc.nextDouble());
        System.out.print("Rental Days: ");
        int carDays = sc.nextInt();
        sc.nextLine();
        vehicles[0] = car;
        Bike bike = new Bike();
        System.out.println("\nEnter details for Bike:");
        System.out.print("Vehicle Number: ");
        bike.setVehicleNumber(sc.nextLine());
        System.out.print("Type: ");
        bike.setType(sc.nextLine());
        System.out.print("Rental Rate per Day: ");
        bike.setRentalRate(sc.nextDouble());
        System.out.print("Insurance Percent: ");
        bike.setInsurancePercent(sc.nextDouble());
        System.out.print("Rental Days: ");
        int bikeDays = sc.nextInt();
        sc.nextLine();
        vehicles[1] = bike;
        Truck truck = new Truck();
        System.out.println("\nEnter details for Truck:");
        System.out.print("Vehicle Number: ");
        truck.setVehicleNumber(sc.nextLine());
        System.out.print("Type: ");
        truck.setType(sc.nextLine());
        System.out.print("Rental Rate per Day: ");
        truck.setRentalRate(sc.nextDouble());
        System.out.print("Insurance Percent: ");
        truck.setInsurancePercent(sc.nextDouble());
        System.out.print("Rental Days: ");
        int truckDays = sc.nextInt();
        sc.nextLine();
        vehicles[2] = truck;
        System.out.println("\nRental Details:");
        vehicles[0].displayDetails(carDays);
        vehicles[1].displayDetails(bikeDays);
        vehicles[2].displayDetails(truckDays);
    }
}
class Car extends Vehicle {
    public double calculateRentalCost(int days) {
        return getRentalRate() * days;
    }
    public double calculateInsurance() {
        return getRentalRate() * insurancePercent / 100;
    }
    public String getInsuranceDetails() {
        return "Car Insurance";
    }
}
class Bike extends Vehicle {
    public double calculateRentalCost(int days) {
        return getRentalRate() * days;
    }
    public double calculateInsurance() {
        return getRentalRate() * insurancePercent / 100;
    }
    public String getInsuranceDetails() {
        return "Bike Insurance";
    }
}
class Truck extends Vehicle {
    public double calculateRentalCost(int days) {
        return getRentalRate() * days;
    }
    public double calculateInsurance() {
        return getRentalRate() * insurancePercent / 100;
    }
    public String getInsuranceDetails() {
        return "Truck Insurance";
    }
}