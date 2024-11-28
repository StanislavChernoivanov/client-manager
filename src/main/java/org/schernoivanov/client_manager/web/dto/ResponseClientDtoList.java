package org.schernoivanov.client_manager.web.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseClientDtoList {

    private List<ResponseClientDto> clients = new ArrayList<>();
}
