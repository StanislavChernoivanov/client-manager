package org.schernoivanov.client_manager.web.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.schernoivanov.client_manager.model.Client;
import org.schernoivanov.client_manager.web.dto.RequestClientDto;
import org.schernoivanov.client_manager.web.dto.ResponseClientDto;
import org.schernoivanov.client_manager.web.dto.ResponseClientDtoList;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ClientMapper {

    Client RequestClientDtoToClient(RequestClientDto requestClientDto);

    ResponseClientDto clientToResponseClientDto(Client client);

    List<ResponseClientDto> clientListToResponseList(List<Client> clients);

    default ResponseClientDtoList clientListToResponseClientList(List<Client> clients) {
        var responseClientDtoList = new ResponseClientDtoList();
        responseClientDtoList.setClients(clientListToResponseList(clients));

        return responseClientDtoList;
    }
}
