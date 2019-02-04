package br.coordinates.repository;

import br.coordinates.dto.CollaboratorDto;
import br.coordinates.model.Collaborator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CollaboratorRepository extends JpaRepository<Collaborator, Integer> {

    @Query("SELECT new br.coordinates.dto.CollaboratorDto(c) FROM Collaborator c")
    List<CollaboratorDto> getAllDto();

    @Query("SELECT new br.coordinates.dto.CollaboratorDto(c) FROM Collaborator c WHERE c.id = :id")
    CollaboratorDto getOneDto(@Param("id") Integer id);
}
