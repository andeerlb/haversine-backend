package br.coordinates.repository;

import br.coordinates.model.Geolocation;
import br.coordinates.model.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StoreRepository extends JpaRepository<Store, Integer> {

    @Query("SELECT s FROM Store s WHERE (s.city.id = :cityId or :cityId IS NULL)")
    List<Store> findAllByCity(@Param("cityId") Integer cityId);
}
