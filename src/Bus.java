public class Bus {
    private int busId;
    private String busNumber;
    private String source;
    private String destination;
    private int totalSeats;
    private int availableSeats;

    // Constructor
    public Bus(int busId, String busNumber, String source, String destination, int totalSeats) {
        this.busId = busId;
        this.busNumber = busNumber;
        this.source = source;
        this.destination = destination;
        this.totalSeats = totalSeats;
        this.availableSeats = totalSeats; // Initially, all seats are available
    }

    // Getters and Setters
    public int getBusId() { return busId; }
    public String getBusNumber() { return busNumber; }
    public String getSource() { return source; }
    public String getDestination() { return destination; }
    public int getTotalSeats() { return totalSeats; }
    public int getAvailableSeats() { return availableSeats; }

    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
    }
}
