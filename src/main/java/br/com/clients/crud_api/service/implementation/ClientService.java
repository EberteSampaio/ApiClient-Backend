package br.com.clients.crud_api.service.implementation;

import br.com.clients.crud_api.model.Client;
import br.com.clients.crud_api.model.dto.ClientRequest;
import br.com.clients.crud_api.model.dto.ClientResponse;
import br.com.clients.crud_api.repository.ClientRepository;
import br.com.clients.crud_api.service.IClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class ClientService implements IClientService {

    private ClientRepository repository;


    public Stream<ClientResponse> all(){
        return this.repository.findAll().stream().map(
                client -> {return new ClientResponse(client);}
        );
    }
    @Override
    public ClientResponse save(ClientRequest client) {

        return new ClientResponse(this.repository.save(new Client(client)));
    }

    @Override
    public ClientResponse edit(Long id, ClientRequest clientRequest) {
        return this.repository.findById(id).map(client -> {
            client.updateData(clientRequest);

            return new ClientResponse(client);
        }).orElseThrow();
    }

    @Override
    public void delete(Long id) {
        this.repository.deleteById(id);
    }
}
