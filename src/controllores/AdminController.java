package controllers;

import Models.Client;
import dao.ClientDAO;

public class AdminController {

    private ClientDAO clientDAO;

    public AdminController() {
        this.clientDAO = new ClientDAO();
    }

    public void addClient(String name, int age, String gender, String contactDetails, int subscriptionId) {
        Client client = new Client(0, name, age, gender, contactDetails, subscriptionId);
        clientDAO.addClient(client);
    }

    // Other admin-related functions (view clients, view reports, etc.)
}
