package br.com.clients.crud_api.model.dto;

public record ClientRequest(

        String companyName,
        String identificationNumber,
        String email,
        String companySector
) {

}
