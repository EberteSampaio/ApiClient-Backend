package br.com.clients.crud_api.controller;

import br.com.clients.crud_api.domain.dto.ClientRequest;
import br.com.clients.crud_api.domain.dto.ClientResponse;
import br.com.clients.crud_api.domain.service.IClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Stream;

@RestController
@RequestMapping("/client")
@RequiredArgsConstructor
public class ClientController {

    private IClientService service;

    @GetMapping
    @ResponseStatus(HttpStatus.FOUND)
    public Stream<ClientResponse> all(){
        return this.service.all();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ClientResponse create(@RequestBody ClientRequest clientRequest){
        return this.service.save(clientRequest);
    }

    @PatchMapping("/{id}")
    public ClientResponse edit( @PathVariable Long id, @RequestBody ClientRequest clientRequest){
        return this.service.edit(id, clientRequest);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){
        this.service.delete(id);
    }
}
