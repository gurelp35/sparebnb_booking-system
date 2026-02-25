// Sofa.java
// This class represents a Sofa as a type of accommodation.
// A sofa means a guest can rent just a couch or shared sleeping space.
// It inherits from the abstract class Accommodation.

public class Sofa extends Accommodation {
    // ==============================
    // Fields (Properties)
    // ==============================
    private boolean sharedRoom; // Indicates if the sofa is in a shared room

    // ==============================
    // Constructor
    // ==============================
    // Initialize a Sofa object with id, name, price per night, location, and shared room option.
    public Sofa(int id, String name, double pricePerNight, String location, boolean sharedRoom) {
        super(id, name, pricePerNight, location); // Call the parent constructor
        this.sharedRoom = sharedRoom;
    }

    // ==============================
    // Overridden Method (Polymorphism)
    // ==============================
    // This method prints details of the Sofa in a user-friendly format.
    @Override
    public void print() {
        System.out.println("Sofa: " + getName() +
                " | Shared Room: " + (sharedRoom ? "Yes" : "No") +
                " | Location: " + getLocation() +
                " | Price: $" + getPricePerNight() +
                " | Facilities: " + facilitiesAsText());
    }
}