import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BusDAO busDAO = new BusDAO();
        PassengerDAO passengerDAO = new PassengerDAO();
        ReservationDAO reservationDAO = new ReservationDAO();

        while (true) {
            System.out.println("1. Add Bus");
            System.out.println("2. Add Passenger");
            System.out.println("3. Make Reservation");
            System.out.println("4. Exit");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter Bus ID, Number, Source, Destination, Total Seats:");
                    int busId = scanner.nextInt();
                    String busNumber = scanner.next();
                    String source = scanner.next();
                    String destination = scanner.next();
                    int totalSeats = scanner.nextInt();
                    Bus bus = new Bus(busId, busNumber, source, destination, totalSeats);
                    busDAO.addBus(bus);
                    break;
                case 2:
                    System.out.println("Enter Passenger ID, Name, Email:");
                    int passengerId = scanner.nextInt();
                    String name = scanner.next();
                    String email = scanner.next();
                    Passenger passenger = new Passenger(passengerId, name, email);
                    passengerDAO.addPassenger(passenger);
                    break;
                case 3:
                    System.out.println("Enter Reservation ID, Passenger ID, Bus ID, Seat Number:");
                    int reservationId = scanner.nextInt();
                    int resPassengerId = scanner.nextInt();
                    int resBusId = scanner.nextInt();
                    int seatNumber = scanner.nextInt();
                    Reservation reservation = new Reservation(reservationId, resPassengerId, resBusId, seatNumber);
                    reservationDAO.addReservation(reservation);
                    busDAO.updateBusSeats(resBusId, busDAO.getBusById(resBusId).getAvailableSeats() - 1);
                    break;
                case 4:
                    System.out.println("Exiting...");
                    return;
            }
        }
    }
}
