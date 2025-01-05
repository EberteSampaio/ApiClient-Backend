package br.com.clients.crud_api.domain.dto;

public record ClientRequest(

        String companyName,
        String identificationNumber,
        String email,
        String companySector
) {

}
