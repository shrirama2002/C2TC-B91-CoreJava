public class Passenger {
    private int passengerId;
    private String name;
    private String email;

    // Constructor
    public Passenger(int passengerId, String name, String email) {
        this.passengerId = passengerId;
        this.name = name;
        this.email = email;
    }

    // Getters and Setters
    public int getPassengerId() { return passengerId; }
    public String getName() { return name; }
    public String getEmail() { return email; }
}
