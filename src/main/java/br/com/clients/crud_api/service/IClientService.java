package br.com.clients.crud_api.service;

import br.com.clients.crud_api.model.dto.ClientRequest;
import br.com.clients.crud_api.model.dto.ClientResponse;
import java.util.stream.Stream;

public interface IClientService {
    Stream<ClientResponse> all();
    ClientResponse save(ClientRequest client);
    ClientResponse edit(Long id, ClientRequest clientRequest);
    void delete(Long id);
}
