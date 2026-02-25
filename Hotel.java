// Hotel.java
// This class represents a Hotel as a type of accommodation.
// It inherits from the abstract class Accommodation.
package model;
public class Hotel extends Accommodation {
    // ==============================
    // Fields (Properties)
    // ==============================
    private int stars; // Number of stars the hotel has (e.g., 3-star, 5-star)

    // ==============================
    // Constructor
    // ==============================
    // Initialize a Hotel object with id, name, price per night, location, and stars.
    public Hotel(int id, String name, double pricePerNight, String location, int stars) {
        super(id, name, pricePerNight, location); // Call the parent constructor
        this.stars = stars;
    }

    // ==============================
    // Overridden Method (Polymorphism)
    // ==============================
    // This method prints details of the Hotel in a user-friendly format.
    @Override
    public void print() {
        System.out.println("Hotel: " + getName() +
                " | Stars: " + stars +
                " | Location: " + getLocation() +
                " | Price: $" + getPricePerNight() +
                " | Facilities: " + facilitiesAsText());
    }
}

