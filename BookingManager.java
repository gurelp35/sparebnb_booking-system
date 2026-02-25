// BookingManager.java
import java.util.*;

public class BookingManager {
    private static BookingManager instance;

    private final Map<Integer, User> users = new HashMap<>();
    private final List<Accommodation> items = new ArrayList<>();
    private final Map<Accommodation, Booking> activeBookings = new HashMap<>();
    private int nextBookingId = 1;

    private BookingManager() {}

    public static BookingManager getInstance() {
        if (instance == null) {
            instance = new BookingManager();
        }
        return instance;
    }
    // Aggregation
    public void registerUser(User u) {
        users.put(u.getId(), u);
    }
    public void registerItem(Accommodation a) {
        items.add(a);
    }
    //
    public boolean isAvailable(Accommodation a) {
        return !activeBookings.containsKey(a);
    }
    public List<Accommodation> listAvailable() {
        List<Accommodation> list = new ArrayList<>();
        for (Accommodation a : items) {
            if (isAvailable (a)) list.add(a);
        }
        return list;
    }
    // Booking
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
            System.out.println(" Sorry " + u.getName() + ", \"" + a.getName() + "\" is currently unavailable.");
            return null;
        }
        Booking b = new Booking(nextBookingId++, u, a);
        activeBookings.put(a, b);

        // Advanced: loyalty points
        u.addPoints(10);

        System.out.println(" Booking successful: " + b);
        return b;
    }

    public boolean release(Accommodation a) {
        Booking b = activeBookings.get(a);
        if (b == null) return false;
        b.release();
        activeBookings.remove(a);
        System.out.println(" Released: " +b);
        return true;
    }
    public void printStatus() {
        System.out.println("\n=== CURRENT STATUS ===");
        System.out.println("Users:");
        for (User u : users.values()) {
            System.out.println(" - " + u);
        }
        System.out.println("\nItems:");
        for (Accommodation a: items) {
            String availability = isAvailable(a) ? "AVAILABLE" : "BOOKED";
            System.out.println(" - " + a.getName() + " | " + a.getLocation() + " | $" + a.getPricePerNight() + " | " + availability);
        }
        System.out.println("\nActive Bookings:");
        if (activeBookings.isEmpty()) {
            System.out.println(" (none)");
        } else {
            for (Booking b : activeBookings.values()) {
                System.out.println(" - " + b);
            }
        }
        System.out.println("=====================\n");
    }
}
