// Accommodation.java
// This is an abstract class that represents a general type of accommodation (place to stay).
// It will be the parent class for Flat, Hotel, Villa, and Sofa.

import java.util.ArrayList;
import java.util.List;

public abstract class Accommodation {
    // ==============================
    // Fields (Properties)
    // ==============================
    private int id;                   // Unique ID for the accommodation
    private String name;              // Name of the accommodation (e.g., "City Center Flat")
    private double pricePerNight;     // Price per night in USD
    private String location;          // Location (e.g., "London")
    private List<Facility> facilities; // Composition: List of facilities available

    // ==============================
    // Constructor
    // ==============================
    // This constructor initializes the accommodation with its main attributes.
    public Accommodation(int id, String name, double pricePerNight, String location) {
        this.id = id;
        this.name = name;
        this.pricePerNight = pricePerNight;
        this.location = location;
        this.facilities = new ArrayList<>(); // Empty list of facilities by default
    }

    // ==============================
    // Getters (Encapsulation)
    // ==============================
    public int getId() { return id; }
    public String getName() { return name; }
    public double getPricePerNight() { return pricePerNight; }
    public String getLocation() { return location; }

    // ==============================
    // Facilities (Composition)
    // ==============================
    // Add a facility to the list
    public void addFacility(Facility facility) {
        facilities.add(facility);
    }

    // Return the list of facilities
    public List<Facility> getFacilities() {
        return facilities;
    }

    // Helper method: Return facilities as a text string
    protected String facilitiesAsText() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < facilities.size(); i++) {
            sb.append(facilities.get(i).toString());
            if (i < facilities.size() - 1) sb.append(", ");
        }
        return sb.toString();
    }

    // ==============================
    // Abstract Method
    // ==============================
    // Each subclass (Flat, Hotel, Villa, Sofa) must implement this method.
    public abstract void print();
}