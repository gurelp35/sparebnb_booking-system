// Booking.java
package model;
import java.time.LocalDateTime;
public class Booking {
    private int id;
    private User user;
    private Accommodation item;
    private BookingStatus status;
    private LocalDateTime createdAt;
    private LocalDateTime releasedAt;

    public Booking(int id, User user, Accommodation item) {
        this.id = id;
        this.user = user;
        this.item = item;
        this.status = BookingStatus.ACTIVE;
        this.createdAt = LocalDateTime.now();
    }
    public int getId() { return id;}
    public User getUser() { return user;}
    public Accommodation getItem() { return item; }

    public boolean isActive() {
        return status == BookingStatus.ACTIVE;
    }
    public void release() {
        if (status == BookingStatus.ACTIVE) {
            status = BookingStatus.RELEASED;
            releasedAt = LocalDateTime.now();
        }
    }

    @Override
    public String toString() {
        return "Booking#" + id + " { user=" + user.getName() +
                ", item=" + item.getName() +
                ", status=" + status +
                ", createdAt=" + createdAt +
                (releasedAt != null ? ",releasedAt=" + releasedAt : "") +
                "}";
    }
}