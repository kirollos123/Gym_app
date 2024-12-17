package dao;

import Models.Coach;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CoachDAO {

    private Connection connection;

    // Constructor to initialize the database connection
    public CoachDAO() {
        this.connection = DatabaseConnection.getConnection();
    }

    // Method to add a new coach
    public void addCoach(Coach coach) {
        String query = "INSERT INTO coaches (name, specialization, contact_details) VALUES (?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, coach.getName());
            statement.setString(2, coach.getSpecialization());
            statement.setString(3, coach.getContactDetails());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to update an existing coach's details
    public void updateCoach(Coach coach) {
        String query = "UPDATE coaches SET name = ?, specialization = ?, contact_details = ? WHERE id = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, coach.getName());
            statement.setString(2, coach.getSpecialization());
            statement.setString(3, coach.getContactDetails());
            statement.setInt(4, coach.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to delete a coach by their ID
    public void deleteCoach(int id) {
        String query = "DELETE FROM coaches WHERE id = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to get a coach by their ID
    public Coach getCoachById(int id) {
        String query = "SELECT * FROM coaches WHERE id = ?";
        Coach coach = null;

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                coach = new Coach(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("specialization"),
                        resultSet.getString("contact_details")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return coach;
    }

    // Method to get all coaches
    public List<Coach> getAllCoaches() {
        String query = "SELECT * FROM coaches";
        List<Coach> coaches = new ArrayList<>();

        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                Coach coach = new Coach(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("specialization"),
                        resultSet.getString("contact_details")
                );
                coaches.add(coach);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return coaches;
    }
}
