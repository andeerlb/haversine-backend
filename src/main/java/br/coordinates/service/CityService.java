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

    public List<City> getAll() {
        return repo.findAll();
    }
}
