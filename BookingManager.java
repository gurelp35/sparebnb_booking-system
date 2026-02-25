package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BookingManager {

    // Singleton
    private static BookingManager instance;

    // Aggregation / system storage
    private final Map<Integer, User> users = new HashMap<>();
    private final List<Accommodation> items = new ArrayList<>();

    // Active bookings keyed by the item
    private final Map<Accommodation, Booking> activeBookings = new HashMap<>();

    private int nextBookingId = 1;

    private BookingManager() {}

    public static BookingManager getInstance() {
        if (instance == null) {
            instance = new BookingManager();
        }
        return instance;
    }

    // ----------------------------
    // Registration (Aggregation)
    // ----------------------------
    public void registerUser(User u) {
        users.put(u.getId(), u);
    }

    public void registerItem(Accommodation a) {
        items.add(a);
    }

    // ----------------------------
    // Availability
    // ----------------------------
    public boolean isAvailable(Accommodation a) {
        return !activeBookings.containsKey(a);
    }

    // Basic list (Sprint 3 basic)
    public List<Accommodation> listAvailable() {
        List<Accommodation> list = new ArrayList<>();
        for (Accommodation a : items) {
            if (isAvailable(a)) {
                list.add(a);
            }
        }
        return list;
    }

    // Advanced: Stream-based list (Sprint 3 advanced)
    public List<Accommodation> listAvailableStream() {
        return items.stream()
                .filter(this::isAvailable)
                .toList();
    }

    // ----------------------------
    // Booking
    // ----------------------------
    public Booking book(User u, Accommodation a) {

        if (!items.contains(a)) {
            System.out.println("Sorry, this item is not in our system.");
            return null;
        }

        if (!users.containsKey(u.getId())) {
            System.out.println("Sorry, this user is not registered.");
            return null;
        }

        if (!isAvailable(a)) {
            System.out.println("Sorry " + u.getName()
                    + ", \"" + a.getName() + "\" is currently unavailable.");
            return null;
        }

        Booking b = new Booking(nextBookingId++, u, a);
        activeBookings.put(a, b);

        // Advanced: loyalty points
        u.addPoints(10);

        System.out.println("Booking successful: " + b);
        return b;
    }

    public boolean release(Accommodation a) {
        Booking b = activeBookings.get(a);
        if (b == null) {
            return false;
        }
        b.release();
        activeBookings.remove(a);
        System.out.println("Released: " + b);
        return true;
    }

    // ----------------------------
    // Debug / status report (useful for GUI "Show Status")
    // ----------------------------
    public String statusReport() {
        StringBuilder sb = new StringBuilder();
        sb.append("=== CURRENT STATUS ===\n");

        sb.append("Users:\n");
        for (User u : users.values()) {
            sb.append(" - ").append(u).append("\n");
        }

        sb.append("\nItems:\n");
        for (Accommodation a : items) {
            String availability = isAvailable(a) ? "AVAILABLE" : "BOOKED";
            sb.append(" - ")
                    .append(a.getName()).append(" | ")
                    .append(a.getLocation()).append(" | £")
                    .append(a.getPricePerNight()).append(" | ")
                    .append(availability)
                    .append("\n");
        }

        sb.append("\nActive Bookings:\n");
        if (activeBookings.isEmpty()) {
            sb.append(" (none)\n");
        } else {
            for (Booking b : activeBookings.values()) {
                sb.append(" - ").append(b).append("\n");
            }
        }

        sb.append("=====================\n");
        return sb.toString();
    }
    public List<Accommodation> listAll() {
        return items.stream().toList();
    }
}
