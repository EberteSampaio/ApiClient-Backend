package br.com.clients.crud_api.model;

import br.com.clients.crud_api.model.dto.ClientRequest;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "Client")
@Table(name = "tb_clients")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String companyName;
    private String identificationNumber;
    private String email;
    private String companySector;

    public Client(ClientRequest clientRequest){
        this.companyName = clientRequest.companyName();
        this.identificationNumber = clientRequest.identificationNumber();
        this.email = clientRequest.email();
        this.companySector = clientRequest.companySector();
    }

    public void updateData(ClientRequest clientRequest) {
        if(clientRequest.companyName() != null){
            this.setCompanyName(clientRequest.companyName());
        }
        if(clientRequest.identificationNumber() != null){
            this.setIdentificationNumber(clientRequest.identificationNumber());
        }
        if(clientRequest.email() != null){
            this.setEmail(clientRequest.email());
        }
        if(clientRequest.companySector() != null){
            this.setCompanySector(clientRequest.companySector());
        }
    }
}
