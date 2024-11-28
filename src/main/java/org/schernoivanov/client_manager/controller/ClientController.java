package org.schernoivanov.client_manager.controller;

import lombok.RequiredArgsConstructor;
import org.schernoivanov.client_manager.service.ClientService;
import org.schernoivanov.client_manager.web.dto.*;
import org.schernoivanov.client_manager.web.mapper.ClientMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/client")
@RequiredArgsConstructor
public class ClientController {

    private final ClientService clientService;

    private final ClientMapper clientMapper;

    @GetMapping
    public ResponseEntity<ResponseClientDtoList> findAll() {

        return ResponseEntity.ok(clientMapper.clientListToResponseClientList(
                clientService.findAll()
        ));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseClientDto> findById(@PathVariable String id) {

        return ResponseEntity.ok(clientMapper.clientToResponseClientDto(
                clientService.findById(id)
        ));
    }


    @PostMapping
    private ResponseEntity<ResponseClientDto> create(@RequestBody RequestClientDto requestClientDto) {

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(clientMapper.clientToResponseClientDto(
                        clientService.create(clientMapper.RequestClientDtoToClient(requestClientDto))
                ));
    }

    @PatchMapping("/{id}")
    private ResponseEntity<ResponseClientDto> addContact(@PathVariable String id,
                                                         @RequestParam String contact) {

        return ResponseEntity.ok(clientMapper.clientToResponseClientDto(
                clientService.addNewContact(contact, id)
        ));
    }


    @GetMapping("/{id}/contacts")
    private ResponseEntity<Contacts> findContactsById(@RequestParam String id) {
        Contacts contacts = new Contacts();
        contacts.getContacts().addAll(clientService.findContactsById(id));

        return ResponseEntity.ok(contacts);
    }

    @GetMapping("/{id}/contacts")
    private ResponseEntity<Contacts> findContactsById(@RequestParam String id,
                                                      @RequestParam ContactType contactType) {
        Contacts contacts = new Contacts();
        contacts.getContacts().addAll(
                clientService.findContactsByContactTypeAndId(contactType, id));

        return ResponseEntity.ok(contacts);
    }


}
