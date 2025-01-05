package br.com.clients.crud_api.repository;


import br.com.clients.crud_api.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ClientRepository extends JpaRepository<Client, Long> {
}
