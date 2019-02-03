package br.coordinates.service;

import br.coordinates.dto.CollaboratorDto;
import br.coordinates.dto.StoreDto;
import br.coordinates.model.Collaborator;
import br.coordinates.model.Geolocation;
import br.coordinates.model.Store;
import br.coordinates.repository.CollaboratorRepository;
import br.coordinates.repository.GeolocationRepository;
import br.coordinates.repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class StoreService {

    @Autowired
    private StoreRepository repo;

    @Autowired
    private GeolocationRepository geolocationRepository;

    public StoreDto create(StoreDto collaboratorDto) {
        Geolocation geo = new Geolocation();
        geo.setLatitude(new BigDecimal(collaboratorDto.getLatitude()));
        geo.setLongitude(new BigDecimal(collaboratorDto.getLongitude()));
        Geolocation geoSaved = geolocationRepository.save(geo);

        Store col = new Store();
        col.setName(collaboratorDto.getName());
        col.setGeolocation(geoSaved);
        Store storSaved = repo.save(col);
        return new StoreDto(storSaved);
    }
}
