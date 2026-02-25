// Flat.java
// This class represents a Flat (apartment) as a type of accommodation.
// It inherits from the abstract class Accommodation.

public class Flat extends Accommodation {
    // ==============================
    // Fields (Properties)
    // ==============================
    private int numberOfRooms; // The number of rooms in the flat

    // ==============================
    // Constructor
    // ==============================
    // Initialize a Flat object with id, name, price per night, location, and number of rooms.
    public Flat(int id, String name, double pricePerNight, String location, int numberOfRooms) {
        super(id, name, pricePerNight, location); // Call the parent constructor
        this.numberOfRooms = numberOfRooms;
    }

    // ==============================
    // Overridden Method (Polymorphism)
    // ==============================
    // This method prints details of the Flat in a user-friendly format.
    @Override
    public void print() {
        System.out.println("Flat: " + getName() +
                " | Rooms: " + numberOfRooms +
                " | Location: " + getLocation() +
                " | Price: $" + getPricePerNight() +
                " | Facilities: " + facilitiesAsText());
    }
}