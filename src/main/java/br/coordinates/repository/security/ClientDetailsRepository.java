package br.coordinates.repository.security;

import br.coordinates.model.security.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientDetailsRepository extends JpaRepository<Client, String> {

    @Query("SELECT DISTINCT client FROM Client client WHERE client.clientId = :clientId")
    Client findByClientId(@Param("clientId") String clientId);
}
