// Facility.java
// This class represents an additional feature or amenity that can be available in an accommodation.
// Examples: Kitchen, Wi-Fi, Swimming Pool, etc.

public class Facility {
    // ==============================
    // Fields (Properties)
    // ==============================
    private String name;        // The name of the facility (e.g., "Kitchen")
    private String description; // A short description of the facility (e.g., "Fully equipped")

    // ==============================
    // Constructor
    // ==============================
    // This constructor initializes a Facility object with a name and description.
    public Facility(String name, String description) {
        this.name = name;
        this.description = description;
    }

    // ==============================
    // Getters (Encapsulation)
    // ==============================
    // Get the facility's name
    public String getName() {
        return name;
    }

    // Get the facility's description
    public String getDescription() {
        return description;
    }

    // ==============================
    // toString Method
    // ==============================
    // This method returns a user-friendly string representation of the Facility.
    // Example output: "Kitchen (Fully equipped)"
    @Override
    public String toString() {
        return name + " (" + description + ")";
    }
}
