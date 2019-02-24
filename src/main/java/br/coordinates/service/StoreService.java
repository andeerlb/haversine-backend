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
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

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

        City city = cityRepository.getOne(store.getCityId());

        Store stor = new Store();
        stor.setName(store.getName());
        stor.setGeolocation(geoSaved);
        stor.setCity(city);
        Store storSaved = repo.save(stor);
        return new StoreDto(storSaved);
    }

    public Page<StoreDto> getAll(Pageable pageable) {
        return repo.findAllDto(pageable);
    }

    public StoreDto getOne(Integer id){
        return repo.getOneDto(id);
    }

    public Boolean delete(Integer id) {
        Store s = repo.getOne(id);

        if(s == null) {
            return false;
        }

        repo.delete(s);
        return true;
    }

    public StoreDto update(Integer id, StoreDto storeDto){
        StoreDto st = this.getOne(id);

        if(st == null){
            throw new RuntimeException("Estabelecimento não encontrado");
        }
        return this.create(st);
    }
}
