package org.schernoivanov.client_manager.service.impl;

import lombok.RequiredArgsConstructor;
import org.schernoivanov.client_manager.model.Client;
import org.schernoivanov.client_manager.repository.ClientRepository;
import org.schernoivanov.client_manager.service.ClientService;
import org.schernoivanov.client_manager.web.dto.ContactType;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {


    private final ClientRepository clientRepository;

    private static final String EMAIL_REGEX;

    private static final String PHONE_REGEX;

    static {
        EMAIL_REGEX = "^[\\w-\\.]+@[\\w-]+(\\.[\\w-]+)*\\.[a-z]{2,}$";
        PHONE_REGEX = "89[0-9]{9}";
    }

    @Override
    public List<Client> findAll() {
        return clientRepository.findAll();
    }

    @Override
    public Client findById(String id) {

        return clientRepository.findById(id);
    }

    @Override
    public Client create(Client client) {
        client.setId(UUID.randomUUID().toString());

        return clientRepository.add(client);
    }

    @Override
    public Client addNewContact(String contact, String id) {

        if (contact.matches(PHONE_REGEX)) {
            Client client = findById(id);
            client.getPhones().add(contact);
            return client;

        } else if (contact.matches(EMAIL_REGEX)) {
            Client client = findById(id);
            client.getEmails().add(contact);
            return client;
        }

        throw new RuntimeException("Неверно указан формат контакта." +
                " Номер телефона вводить в формате 89998887766, " +
                "email в формате email@email.com");
    }

    @Override
    public Set<String> findContactsById(String id) {
        Client client = findById(id);
        Set<String> contacts = new HashSet<>(client.getPhones());
        contacts.addAll(client.getEmails());

        return contacts;
    }

    @Override
    public Set<String> findContactsByContactTypeAndId(ContactType contactType, String id) {

        return switch (contactType) {
            case EMAIL -> findById(id).getEmails();
            case PHONE -> findById(id).getPhones();
        };

    }
}
