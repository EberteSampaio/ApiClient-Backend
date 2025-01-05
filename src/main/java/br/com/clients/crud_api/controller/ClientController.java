package br.com.clients.crud_api.controller;

import br.com.clients.crud_api.domain.dto.ClientRequest;
import br.com.clients.crud_api.domain.dto.ClientResponse;
import br.com.clients.crud_api.domain.service.IClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Stream;

@RestController
@RequestMapping("/client")
public class ClientController {
    @Autowired
    private IClientService service;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Stream<ClientResponse> all(){
        return this.service.all();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ClientResponse create(@RequestBody ClientRequest clientRequest){
        return this.service.save(clientRequest);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ClientResponse edit( @PathVariable Long id, @RequestBody ClientRequest clientRequest){
        return this.service.edit(id, clientRequest);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){
        this.service.delete(id);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.FOUND)
    public ClientResponse findById(@PathVariable Long id){
        return this.service.findById(id);
    }

}
