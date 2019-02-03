package br.coordinates.service;

import br.coordinates.dto.CollaboratorDto;
import br.coordinates.dto.StoreDto;
import br.coordinates.model.City;
import br.coordinates.model.Collaborator;
import br.coordinates.model.Geolocation;
import br.coordinates.model.Store;
import br.coordinates.repository.CityRepository;
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
    private CityRepository cityRepository;

    @Autowired
    private GeolocationRepository geolocationRepository;

    public StoreDto create(StoreDto store) {
        Geolocation geo = new Geolocation();
        geo.setLatitude(new BigDecimal(store.getLatitude()));
        geo.setLongitude(new BigDecimal(store.getLongitude()));
        Geolocation geoSaved = geolocationRepository.save(geo);

        City city = cityRepository.getOne(store.getCity());

        Store stor = new Store();
        stor.setName(store.getName());
        stor.setGeolocation(geoSaved);
        stor.setCity(city);
        Store storSaved = repo.save(stor);
        return new StoreDto(storSaved);
    }
}
