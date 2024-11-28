package org.schernoivanov.client_manager.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResponseClientDto {

    private String name;

    private Set<String> emails = new HashSet<>();

    private Set<String> phones = new HashSet<>();
}
