package br.coordinates.controller;

import br.coordinates.dto.CollaboratorDto;
import br.coordinates.model.City;
import br.coordinates.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
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

    @PutMapping("{id}")
    public ResponseEntity<City> update(@PathVariable(name = "id") Integer id, @RequestBody City city){
        return ResponseEntity.ok(service.update(id, city));
    }

    @GetMapping(value = "/all")
    public ResponseEntity<Page<City>> getAll(@PageableDefault(size = 10, page = 0) Pageable pageable) {
        return ResponseEntity.ok(service.getAll(pageable));
    }

    @GetMapping
    public ResponseEntity<City> getOne(@RequestParam(name = "id") Integer id) {
        return ResponseEntity.ok(service.getOne(id));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Boolean> delete(@PathVariable(name = "id") Integer id) {
        return ResponseEntity.ok(service.delete(id));
    }
}
