package org.schernoivanov.client_manager.repository;

import org.schernoivanov.client_manager.model.Client;

import java.util.List;


public interface ClientRepository {

    List<Client> findAll();

    Client findById(String id);


    Client add(Client client);
}
