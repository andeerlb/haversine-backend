package br.coordinates.service;

import br.coordinates.dto.CollaboratorDto;
import br.coordinates.dto.ImPossibleCoordinateDto;
import br.coordinates.dto.PossibleCoordinateDto;
import br.coordinates.dto.StoreDto;
import br.coordinates.model.Collaborator;
import br.coordinates.model.Geolocation;
import br.coordinates.model.Store;
import br.coordinates.repository.CollaboratorRepository;
import br.coordinates.repository.GeolocationRepository;
import br.coordinates.repository.StoreRepository;
import br.coordinates.util.CoordinateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Service
public class CollaboratorService {

    @Autowired
    private CollaboratorRepository repo;

    @Autowired
    private GeolocationRepository geolocationRepository;

    public CollaboratorDto create(CollaboratorDto collaboratorDto) {
        Geolocation geo = new Geolocation();
        geo.setLatitude(new BigDecimal(collaboratorDto.getLatitude()));
        geo.setLongitude(new BigDecimal(collaboratorDto.getLongitude()));
        Geolocation geoSaved = geolocationRepository.save(geo);

        Collaborator col = new Collaborator();
        col.setName(collaboratorDto.getName());
        col.setGeolocation(geoSaved);
        Collaborator colSaved = repo.save(col);
        return new CollaboratorDto(colSaved);
    }
}
