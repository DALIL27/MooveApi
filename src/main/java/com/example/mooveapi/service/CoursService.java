package com.example.mooveapi.service;

import com.example.mooveapi.model.Cours;
import com.example.mooveapi.repository.CoursRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoursService {

    private final CoursRepository repository;

    public CoursService(CoursRepository repository) {
        this.repository = repository;
    }

    public List<Cours> getAll() {
        return repository.findAll();
    }

    public Cours getById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Cours create(Cours c) {
        return repository.save(c);
    }

    public Cours update(Long id, Cours newCours) {
        return repository.findById(id)
                .map(cours -> {
                    cours.setNom(newCours.getNom());
                    cours.setDescription(newCours.getDescription());
                    cours.setPrix(newCours.getPrix());
                    return repository.save(cours);
                }).orElse(null);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}