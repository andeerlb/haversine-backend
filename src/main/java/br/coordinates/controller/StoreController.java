package br.coordinates.controller;

import br.coordinates.dto.StoreDto;
import br.coordinates.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
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
    public ResponseEntity<Page<StoreDto>> getAll(@PageableDefault(size = 10, page = 0) Pageable pageable) {
        return ResponseEntity.ok(service.getAll(pageable));
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
