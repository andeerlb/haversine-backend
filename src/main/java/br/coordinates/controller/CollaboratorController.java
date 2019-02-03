package br.coordinates.controller;

import br.coordinates.dto.CollaboratorDto;
import br.coordinates.dto.ImPossibleCoordinateDto;
import br.coordinates.dto.PossibleCoordinateDto;
import br.coordinates.service.CollaboratorService;
import br.coordinates.service.PossibleRouterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/collaborator")
public class CollaboratorController {

    @Autowired
    private CollaboratorService service;

    @PostMapping
    private ResponseEntity<CollaboratorDto> create(@RequestBody CollaboratorDto collaborator) {
        return ResponseEntity.ok(service.create(collaborator));
    }
}
