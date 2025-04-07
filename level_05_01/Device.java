import java.util.Scanner;
class Device {
    protected String deviceId;
    protected String status;
    public Device(String deviceId, String status) {
        this.deviceId = deviceId;
        this.status = status;
    }
    public void displayStatus() {
        System.out.println("Device ID: " + deviceId);
        System.out.println("Status: " + status);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Device details (Device ID, Status): ");
        String deviceId = scanner.nextLine();
        String status = scanner.nextLine();
        System.out.print("Enter Thermostat details (Temperature Setting): ");
        int temperature = scanner.nextInt();
        Device device = new Thermostat(deviceId, status, temperature);
        System.out.println("\nDevice Status:");
        device.displayStatus();
    }
}
class Thermostat extends Device {
    private int temperatureSetting;
    public Thermostat(String deviceId, String status, int temperatureSetting) {
        super(deviceId, status);
        this.temperatureSetting = temperatureSetting;
    }
    @Override
    public void displayStatus() {
        super.displayStatus();
        System.out.println("Temperature Setting: " + temperatureSetting + "°C");
    }
}