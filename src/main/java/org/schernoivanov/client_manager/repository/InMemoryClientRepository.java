package org.schernoivanov.client_manager.repository;

import org.schernoivanov.client_manager.model.Client;
import org.springframework.stereotype.Repository;

import java.text.MessageFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Repository
public class InMemoryClientRepository implements ClientRepository {

    private final Map<String, Client> container = new HashMap<>();


    @Override
    public List<Client> findAll() {
        return container.values().stream().toList();
    }

    @Override
    public Client findById(String id) {
        return container.entrySet()
                .stream()
                .filter(e -> Objects.equals(e.getKey(), id))
                .findAny().orElseThrow(() ->
                        new RuntimeException(MessageFormat.format(
                                "Клиент с id {0} не найден"
                                , id))).getValue();
    }


    @Override
    public Client add(Client client) {
        container.put(client.getId(), client);

        return client;
    }
}
