import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PassengerDAO {
    public void addPassenger(Passenger passenger) {
        Connection connection = DatabaseConnection.connect();
        String sql = "INSERT INTO passengers (passengerId, name, email) VALUES (?, ?, ?)";

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, passenger.getPassengerId());
            statement.setString(2, passenger.getName());
            statement.setString(3, passenger.getEmail());
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            DatabaseConnection.disconnect(connection);
        }
    }

    public Passenger getPassengerById(int passengerId) {
        Connection connection = DatabaseConnection.connect();
        String sql = "SELECT * FROM passengers WHERE passengerId = ?";
        Passenger passenger = null;

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, passengerId);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                passenger = new Passenger(
                        resultSet.getInt("passengerId"),
                        resultSet.getString("name"),
                        resultSet.getString("email")
                );
            }
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            DatabaseConnection.disconnect(connection);
        }

        return passenger;
    }
}
