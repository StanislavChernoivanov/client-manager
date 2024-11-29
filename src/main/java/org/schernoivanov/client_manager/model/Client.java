package org.schernoivanov.client_manager.model;

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
public class Client {

    private String id;

    private String name;

    @Builder.Default
    private Set<String> emails = new HashSet<>();

    @Builder.Default
    private Set<String> phones = new HashSet<>();


}
