package org.schernoivanov.client_manager.service;

import org.schernoivanov.client_manager.model.Client;
import org.schernoivanov.client_manager.web.dto.ContactType;

import java.util.List;
import java.util.Set;

public interface ClientService {

    List<Client> findAll();

    Client findById(String id);

    Client create(Client client);

    Client addNewContact(String contact, String id);

    Set<String> findContactsById(String id);

    Set<String> findContactsByContactTypeAndId(ContactType contactType, String id);
}
