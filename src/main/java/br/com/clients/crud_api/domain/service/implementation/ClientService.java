package br.com.clients.crud_api.domain.service.implementation;

import br.com.clients.crud_api.domain.model.Client;
import br.com.clients.crud_api.domain.dto.ClientRequest;
import br.com.clients.crud_api.domain.dto.ClientResponse;
import br.com.clients.crud_api.domain.repository.ClientRepository;
import br.com.clients.crud_api.domain.service.IClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.stream.Stream;

@Service
public class ClientService implements IClientService {
    @Autowired
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

    @Override
    public ClientResponse findById(Long id){
        return this.repository.findById(id).map(client ->{
            return new ClientResponse(client);
        }).orElseThrow();
    }
}
