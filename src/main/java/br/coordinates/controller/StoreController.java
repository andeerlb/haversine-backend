package br.coordinates.controller;

import br.coordinates.dto.CollaboratorDto;
import br.coordinates.dto.StoreDto;
import br.coordinates.service.CollaboratorService;
import br.coordinates.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/store")
public class StoreController {

    @Autowired
    private StoreService service;

    @PostMapping
    private ResponseEntity<StoreDto> create(@RequestBody StoreDto store) {
        return ResponseEntity.ok(service.create(store));
    }
}
