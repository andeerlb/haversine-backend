package br.coordinates.service.security;

import br.coordinates.exception.exception.ClientException;
import br.coordinates.model.security.Client;
import br.coordinates.repository.security.ClientDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.stereotype.Service;

@Service
public class ClientDetailsServiceImpl implements ClientDetailsService {

    @Autowired
    private ClientDetailsRepository repo;

    @Override
    public Client loadClientByClientId(String clientId) throws ClientRegistrationException {
        Client client = repo.findByClientId(clientId);
        if(client == null) {
            throw new ClientException(String.format("CLIENT %s NOT FOUND", clientId), HttpStatus.NOT_FOUND);
        }
        return client;
    }
}
