package level1;
import java.util.*;
public class HotelBooking {
    String guestName, roomType;
    int nights;
    HotelBooking() {
        this("Unknown", "Standard", 1);
    }
    HotelBooking(String guestName, String roomType, int nights) {
        this.guestName = guestName;
        this.roomType = roomType;
        this.nights = nights;
    }
    HotelBooking(HotelBooking hb) {
        this.guestName = hb.guestName;
        this.roomType = hb.roomType;
        this.nights = hb.nights;
    }
    void display() {
        System.out.println("Guest: " + guestName + ", Room Type: " + roomType + ", Nights: " + nights);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Guest Name: ");
        String guestName = sc.nextLine();
        System.out.print("Enter Room Type: ");
        String roomType = sc.nextLine();
        System.out.print("Enter Number of Nights: ");
        int nights = sc.nextInt();
        HotelBooking hb1 = new HotelBooking();
        HotelBooking hb2 = new HotelBooking(guestName, roomType, nights);
        HotelBooking hb3 = new HotelBooking(hb2);
        hb1.display();
        hb2.display();
        hb3.display();
    }
}
