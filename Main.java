// Main.java - Sprint 2 Demo
// This class is the entry point of the application.
// It demonstrates creating different types of accommodations and printing their details.
public class Main {
    public static void main(String[] args) {
        // --- Items Sprint 1 ---
        Flat flat = new Flat(1, "City Center Flat", 100.0, "London", 2);
        flat.addFacility(new Facility("Kitchen", "Fully equipped"));
        flat.addFacility(new Facility("Washing Machine", "Free to use"));

        Hotel hotel = new Hotel(2, "Grand Hotel", 200.0, "Paris", 5);
        hotel.addFacility(new Facility("Pool", "Outdoor swimming pool"));
        hotel.addFacility(new Facility("Wi-Fi", "Free high-speed internet"));

        Villa villa = new Villa(3, "Luxury Villa", 500.0, "Barcelona", true);
        villa.addFacility(new Facility("Private Garden", "Beautiful green area"));

        Sofa sofa = new Sofa(4, "Cozy Sofa", 20.0, "Berlin", true);
        sofa.addFacility(new Facility("Shared Kitchen", "Basic cooking facilities"));

        // --- Users (>=3) ---
        User alice = new User(101, "Alice Smith", "alice@example.com");
        User bob   = new User(102, "Bob Lee", "bob@example.com");
        User lily  = new User(103,  "Lily Rose", "lily@example.com");

        // --- Booking Manager (Singleton) ---
        BookingManager bm = BookingManager.getInstance();

        // Register users & items (aggregation)
        bm.registerUser(alice);
        bm.registerUser(bob);
        bm.registerUser(lily);

        bm.registerItem(flat);
        bm.registerItem(hotel);
        bm.registerItem(villa);
        bm.registerItem(sofa);

        System.out.println("\n===== ALL ITEMS (with details) =====\n");
        flat.print();
        hotel.print();
        villa.print();
        sofa.print();

        bm.printStatus();

        System.out.println(">>> Demo: booking flow\n");

        // 1) Alice books the Hotel (success)
        bm.book(alice, hotel);

        // 2) Bob tries to book the same Hotel ( politely refused)
        bm.book(bob, hotel);

        bm.printStatus();

        // 3) Alice release the Hotel
        bm.release(hotel);

        // 4) Bob tries again (now success)
        bm.book(bob, hotel);

        bm.printStatus();

        System.out.println("--- End of Sprint 2 Demo ---");
    }
}