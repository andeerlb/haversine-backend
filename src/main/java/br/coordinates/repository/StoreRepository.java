package br.coordinates.repository;

import br.coordinates.model.Geolocation;
import br.coordinates.model.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StoreRepository extends JpaRepository<Store, Integer> {
}
