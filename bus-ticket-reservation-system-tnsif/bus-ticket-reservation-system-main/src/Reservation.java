public class Reservation {
    private int reservationId;
    private int passengerId;
    private int busId;
    private int seatNumber;

    // Constructor
    public Reservation(int reservationId, int passengerId, int busId, int seatNumber) {
        this.reservationId = reservationId;
        this.passengerId = passengerId;
        this.busId = busId;
        this.seatNumber = seatNumber;
    }

    // Getters and Setters
    public int getReservationId() { return reservationId; }
    public int getPassengerId() { return passengerId; }
    public int getBusId() { return busId; }
    public int getSeatNumber() { return seatNumber; }
}
