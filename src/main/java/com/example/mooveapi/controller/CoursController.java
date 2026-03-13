package com.example.mooveapi.controller;

import com.example.mooveapi.model.Cours;
import com.example.mooveapi.service.CoursService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cours")
@CrossOrigin("*")
public class CoursController {

    private final CoursService service;

    public CoursController(CoursService service) {
        this.service = service;
    }

    @GetMapping
    public List<Cours> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Cours getOne(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping
    public Cours create(@RequestBody Cours cours) {
        return service.create(cours);
    }

    @PutMapping("/{id}")
    public Cours update(@PathVariable Long id, @RequestBody Cours cours) {
        return service.update(id, cours);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}