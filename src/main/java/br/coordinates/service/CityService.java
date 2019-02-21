package br.coordinates.service;

import br.coordinates.dto.CollaboratorDto;
import br.coordinates.model.City;
import br.coordinates.model.Collaborator;
import br.coordinates.model.Geolocation;
import br.coordinates.repository.CityRepository;
import br.coordinates.repository.CollaboratorRepository;
import br.coordinates.repository.GeolocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class CityService {

    @Autowired
    private CityRepository repo;

    public City create(City city) {
        return repo.save(city);
    }

    public City update(Integer id, City city){
        City c = this.getOne(id);

        if(c == null){
            throw new RuntimeException("Cidade não encontrada.");
        }
        return this.create(city);
    }

    public List<City> getAll() {
        return repo.findAll();
    }

    public City getOne(Integer id){
        return repo.getOne(id);
    }

    public Boolean delete(Integer id) {
        City c = repo.getOne(id);

        if(c == null) {
            return false;
        }

        repo.delete(c);
        return true;
    }
}
