package br.com.clients.crud_api.domain.model;

import br.com.clients.crud_api.domain.dto.ClientRequest;
import jakarta.persistence.*;

@Entity(name = "Client")
@Table(name = "tb_clients")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String companyName;
    private String identificationNumber;
    private String email;
    private String companySector;

    public Client(Long id, String companyName, String identificationNumber, String email, String companySector) {
        this.id = id;
        this.companyName = companyName;
        this.identificationNumber = identificationNumber;
        this.email = email;
        this.companySector = companySector;
    }

    public Client(){

    }

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

    public Long getId() {
        return id;
    }

    public Client setId(Long id) {
        this.id = id;
        return this;
    }

    public String getCompanyName() {
        return companyName;
    }

    public Client setCompanyName(String companyName) {
        this.companyName = companyName;
        return this;
    }

    public String getIdentificationNumber() {
        return identificationNumber;
    }

    public Client setIdentificationNumber(String identificationNumber) {
        this.identificationNumber = identificationNumber;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public Client setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getCompanySector() {
        return companySector;
    }

    public Client setCompanySector(String companySector) {
        this.companySector = companySector;
        return this;
    }
}
