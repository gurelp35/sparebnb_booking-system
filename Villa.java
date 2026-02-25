// Villa.java
// This class represents a Villa as a type of accommodation.
// It inherits from the abstract class Accommodation.

public class Villa extends Accommodation {
    // ==============================
    // Fields (Properties)
    // ==============================
    private boolean hasPool; // Indicates whether the villa has a swimming pool

    // ==============================
    // Constructor
    // ==============================
    // Initialize a Villa object with id, name, price per night, location, and pool availability.
    public Villa(int id, String name, double pricePerNight, String location, boolean hasPool) {
        super(id, name, pricePerNight, location); // Call the parent constructor
        this.hasPool = hasPool;
    }

    // ==============================
    // Overridden Method (Polymorphism)
    // ==============================
    // This method prints details of the Villa in a user-friendly format.
    @Override
    public void print() {
        System.out.println("Villa: " + getName() +
                " | Pool: " + (hasPool ? "Yes" : "No") +
                " | Location: " + getLocation() +
                " | Price: $" + getPricePerNight() +
                " | Facilities: " + facilitiesAsText());
    }
}
