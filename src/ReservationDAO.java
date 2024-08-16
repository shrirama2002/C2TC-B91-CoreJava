import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ReservationDAO {
    public void addReservation(Reservation reservation) {
        Connection connection = DatabaseConnection.connect();
        String sql = "INSERT INTO reservations (reservationId, passengerId, busId, seatNumber) VALUES (?, ?, ?, ?)";

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, reservation.getReservationId());
            statement.setInt(2, reservation.getPassengerId());
            statement.setInt(3, reservation.getBusId());
            statement.setInt(4, reservation.getSeatNumber());
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            DatabaseConnection.disconnect(connection);
        }
    }

    public Reservation getReservationById(int reservationId) {
        Connection connection = DatabaseConnection.connect();
        String sql = "SELECT * FROM reservations WHERE reservationId = ?";
        Reservation reservation = null;

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, reservationId);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                reservation = new Reservation(
                        resultSet.getInt("reservationId"),
                        resultSet.getInt("passengerId"),
                        resultSet.getInt("busId"),
                        resultSet.getInt("seatNumber")
                );
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            DatabaseConnection.disconnect(connection);
        }

        return reservation;
    }
}
