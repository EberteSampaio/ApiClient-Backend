package br.com.clients.crud_api.domain.repository;


import br.com.clients.crud_api.domain.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ClientRepository extends JpaRepository<Client, Long> {
}
