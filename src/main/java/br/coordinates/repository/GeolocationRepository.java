package br.coordinates.repository;

import br.coordinates.model.Collaborator;
import br.coordinates.model.Geolocation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GeolocationRepository extends JpaRepository<Geolocation, Integer> {
}
