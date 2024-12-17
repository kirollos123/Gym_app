package dao;

import Models.Client;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClientDAO {

    public void addClient(Client client) {
        String query = "INSERT INTO clients (name, age, gender, contact_details, subscription_id) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, client.getName());
            stmt.setInt(2, client.getAge());
            stmt.setString(3, client.getGender());
            stmt.setString(4, client.getContactDetails());
            stmt.setInt(5, client.getSubscriptionId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Client getClientById(int id) {
        String query = "SELECT * FROM clients WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Client(rs.getInt("id"), rs.getString("name"), rs.getInt("age"),
                        rs.getString("gender"), rs.getString("contact_details"), rs.getInt("subscription_id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Other CRUD operations (update, delete, etc.)
}
