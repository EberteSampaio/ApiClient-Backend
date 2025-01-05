package br.com.clients.crud_api.model.dto;
import br.com.clients.crud_api.model.Client;

public record ClientResponse(
        Long id,
        String companyName,
        String identificationNumber,
        String email,
        String companySector
) {

    public ClientResponse(Client client){
        this(
                client.getId(),
                client.getCompanyName(),
                client.getIdentificationNumber(),
                client.getEmail(),
                client.getCompanySector()
        );
    }
}
