package br.coordinates.controller;

import br.coordinates.dto.CollaboratorDto;
import br.coordinates.dto.ImPossibleCoordinateDto;
import br.coordinates.dto.PossibleCoordinateDto;
import br.coordinates.model.Collaborator;
import br.coordinates.service.CollaboratorService;
import br.coordinates.service.PossibleRouterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/collaborator")
public class CollaboratorController {

    @Autowired
    public CollaboratorService service;

    @PostMapping
    public ResponseEntity<CollaboratorDto> create(@RequestBody CollaboratorDto collaborator) {
        return ResponseEntity.ok(service.create(collaborator));
    }

    @GetMapping("/all")
    public ResponseEntity<Page<CollaboratorDto>> getAll(@PageableDefault(size = 40, page = 0) Pageable pageable) {
        return ResponseEntity.ok(service.getAll(pageable));
    }

    @GetMapping
    public ResponseEntity<CollaboratorDto> getOne(@RequestParam(name = "id") Integer id) {
        return ResponseEntity.ok(service.getOne(id));
    }

    @PutMapping("{id}")
    public ResponseEntity<CollaboratorDto> update(@PathVariable(name = "id") Integer id, @RequestBody CollaboratorDto collaborator){
        return ResponseEntity.ok(service.update(id, collaborator));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Boolean> delete(@PathVariable(name = "id") Integer id) {
        return ResponseEntity.ok(service.delete(id));
    }
}
