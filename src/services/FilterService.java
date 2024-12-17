package services;

import Models.Client;
import java.util.List;
import java.util.stream.Collectors;

public class FilterService {

    public List<Client> filterClientsByAge(List<Client> clients, int minAge, int maxAge) {
        return clients.stream()
                .filter(client -> client.getAge() >= minAge && client.getAge() <= maxAge)
                .collect(Collectors.toList());
    }
}
