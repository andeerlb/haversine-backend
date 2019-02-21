package br.coordinates.controller;

import br.coordinates.dto.CollaboratorDto;
import br.coordinates.dto.StoreDto;
import br.coordinates.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/store")
public class StoreController {

    @Autowired
    private StoreService service;

    @PostMapping
    private ResponseEntity<StoreDto> create(@RequestBody StoreDto store) {
        return ResponseEntity.ok(service.create(store));
    }

    @PutMapping("{id}")
    public ResponseEntity<StoreDto> update(@PathVariable(name = "id") Integer id, @RequestBody StoreDto storeDto){
        return ResponseEntity.ok(service.update(id, storeDto));
    }

    @GetMapping(value = "/all")
    public ResponseEntity<List<StoreDto>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping
    public ResponseEntity<StoreDto> getOne(@RequestParam(name = "id") Integer id) {
        return ResponseEntity.ok(service.getOne(id));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Boolean> delete(@PathVariable(name = "id") Integer id) {
        return ResponseEntity.ok(service.delete(id));
    }
}
