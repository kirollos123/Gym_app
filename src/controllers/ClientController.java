package controllers;

import dao.ClientDAO;
import Models.Client;
import services.ValidationService;

import java.util.List;

public class ClientController {

    private ClientDAO clientDAO;
    private ValidationService validationService;

    public ClientController() {
        this.clientDAO = new ClientDAO();
        this.validationService = new ValidationService();
    }

    // Method to add a new client
    public String addClient(String name, String email, String contactNumber, String address) {
        if (validationService.isValidEmail(email) && validationService.isValidPhoneNumber(contactNumber)) {
            Client client = new Client(name, email, contactNumber, address);
            clientDAO.addClient(client);
            return "Client added successfully.";
        } else {
            return "Invalid email or phone number.";
        }
    }

    // Method to update an existing client
    public String updateClient(int id, String name, String email, String contactNumber, String address) {
        if (validationService.isValidEmail(email) && validationService.isValidPhoneNumber(contactNumber)) {
            Client client = new Client(id, name, email, contactNumber, address);
            clientDAO.updateClient(client);
            return "Client updated successfully.";
        } else {
            return "Invalid email or phone number.";
        }
    }

    // Method to delete a client
    public String deleteClient(int id) {
        clientDAO.deleteClient(id);
        return "Client deleted successfully.";
    }

    // Method to get a client by their ID
    public Client getClientById(int id) {
        return clientDAO.getClientById(id);
    }

    // Method to get all clients
    public List<Client> getAllClients() {
        return clientDAO.getAllClients();
    }
}
