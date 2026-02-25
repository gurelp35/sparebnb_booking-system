// User.java
public class User {
    private int id;
    private String name;
    private String email;
    private int loyaltyPoints;

    public User(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.loyaltyPoints = 0;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getEmail() { return email; }

    public void addPoints(int p) {
        if (p > 0) this.loyaltyPoints += p;
    }

    public int getPoints() { return loyaltyPoints; }

    @Override
    public String toString() {
        return name + " (" + email + "), points=" + loyaltyPoints;
    }
}
