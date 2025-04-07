package level1;
import java.util.*;
public class CarRental {
    String customerName, carModel;
    int rentalDays;
    double dailyRate;
    CarRental(String customerName, String carModel, int rentalDays, double dailyRate) {
        this.customerName = customerName;
        this.carModel = carModel;
        this.rentalDays = rentalDays;
        this.dailyRate = dailyRate;
    }
    double calculateTotalCost() {
        return rentalDays * dailyRate;
    }
    void displayDetails() {
        System.out.println("Customer: " + customerName + ", Car Model: " + carModel + ", Rental Days: " + rentalDays + ", Daily Rate: $" + dailyRate + ", Total Cost: $" + calculateTotalCost());
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Customer Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Car Model: ");
        String model = sc.nextLine();
        System.out.print("Enter Rental Days: ");
        int days = sc.nextInt();
        System.out.print("Enter Daily Rental Rate: ");
        double rate = sc.nextDouble();
        CarRental rental = new CarRental(name, model, days, rate);
        rental.displayDetails();
    }
}
