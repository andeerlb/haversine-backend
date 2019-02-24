package br.coordinates.repository;

import br.coordinates.dto.CollaboratorDto;
import br.coordinates.model.Collaborator;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CollaboratorRepository extends JpaRepository<Collaborator, Integer> {

    @Query("SELECT new br.coordinates.dto.CollaboratorDto(c) FROM Collaborator c")
    Page<CollaboratorDto> getAllDto(Pageable pageable);

    @Query("SELECT new br.coordinates.dto.CollaboratorDto(c) FROM Collaborator c WHERE c.id = :id")
    CollaboratorDto getOneDto(@Param("id") Integer id);

    @Query("SELECT c FROM Collaborator c WHERE (c.city.id = :cityId or :cityId IS NULL)")
    List<Collaborator> findAllByCity(@Param("cityId") Integer cityId);
}
