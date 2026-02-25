// Main.java
// This class is the entry point of the application.
// It demonstrates creating different types of accommodations and printing their details.

public class Main {
    public static void main(String[] args) {
        // ==============================
        // Create a Flat
        // ==============================
        Flat flat = new Flat(1, "City Center Flat", 100.0, "London", 2);
        flat.addFacility(new Facility("Kitchen", "Fully equipped"));
        flat.addFacility(new Facility("Washing Machine", "Free to use"));

        // ==============================
        // Create a Hotel
        // ==============================
        Hotel hotel = new Hotel(2, "Grand Hotel", 200.0, "Paris", 5);
        hotel.addFacility(new Facility("Pool", "Outdoor swimming pool"));
        hotel.addFacility(new Facility("Wi-Fi", "Free high-speed internet"));

        // ==============================
        // Create a Villa
        // ==============================
        Villa villa = new Villa(3, "Luxury Villa", 500.0, "Barcelona", true);
        villa.addFacility(new Facility("Private Garden", "Beautiful green area"));

        // ==============================
        // Create a Sofa
        // ==============================
        Sofa sofa = new Sofa(4, "Cozy Sofa", 20.0, "Berlin", true);
        sofa.addFacility(new Facility("Shared Kitchen", "Basic cooking facilities"));

        // ==============================
        // Print all objects (Polymorphism in action)
        // ==============================
        flat.print();
        hotel.print();
        villa.print();
        sofa.print();

        System.out.println("\n--- End of Accommodation List ---");
    }
}