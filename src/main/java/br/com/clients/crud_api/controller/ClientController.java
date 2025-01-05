package br.com.clients.crud_api.controller;

import br.com.clients.crud_api.domain.dto.ClientRequest;
import br.com.clients.crud_api.domain.dto.ClientResponse;
import br.com.clients.crud_api.domain.service.IClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Stream;

@RestController
@CrossOrigin(origins = "*")
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
    @Transactional
    public ClientResponse create(@RequestBody ClientRequest clientRequest){
        return this.service.save(clientRequest);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Transactional
    public ClientResponse edit( @PathVariable("id") Long id, @RequestBody ClientRequest clientRequest){
        return this.service.edit(id, clientRequest);
    }

    @DeleteMapping("/{id}")
    @Transactional
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") Long id){
        this.service.delete(id);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.FOUND)
    public ClientResponse findById(@PathVariable("id") Long id){
        return this.service.findById(id);
    }
}
