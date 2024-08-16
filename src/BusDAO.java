import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BusDAO {
    public void addBus(Bus bus) {
        Connection connection = DatabaseConnection.connect();
        String sql = "INSERT INTO buses (busId, busNumber, source, destination, totalSeats, availableSeats) VALUES (?, ?, ?, ?, ?, ?)";

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, bus.getBusId());
            statement.setString(2, bus.getBusNumber());
            statement.setString(3, bus.getSource());
            statement.setString(4, bus.getDestination());
            statement.setInt(5, bus.getTotalSeats());
            statement.setInt(6, bus.getAvailableSeats());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseConnection.disconnect(connection);
        }
    }

    public Bus getBusById(int busId) {
        Connection connection = DatabaseConnection.connect();
        String sql = "SELECT * FROM buses WHERE busId = ?";
        Bus bus = null;

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, busId);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                bus = new Bus(
                        resultSet.getInt("busId"),
                        resultSet.getString("busNumber"),
                        resultSet.getString("source"),
                        resultSet.getString("destination"),
                        resultSet.getInt("totalSeats")
                );
                bus.setAvailableSeats(resultSet.getInt("availableSeats"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseConnection.disconnect(connection);
        }

        return bus;
    }

    public void updateBusSeats(int busId, int seats) {
        Connection connection = DatabaseConnection.connect();
        String sql = "UPDATE buses SET availableSeats = ? WHERE busId = ?";

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, seats);
            statement.setInt(2, busId);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseConnection.disconnect(connection);
        }
    }
}
