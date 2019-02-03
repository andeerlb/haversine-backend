package br.coordinates.controller;

import br.coordinates.model.City;
import br.coordinates.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/city")
public class CityController {

    @Autowired
    private CityService service;

    @PostMapping
    public ResponseEntity<City> create(@RequestBody City city) {
        return ResponseEntity.ok(service.create(city));
    }

    @GetMapping(value = "/all")
    public ResponseEntity<List<City>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }
}
