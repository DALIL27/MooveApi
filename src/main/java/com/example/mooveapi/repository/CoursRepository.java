package com.example.mooveapi.repository;

import com.example.mooveapi.model.Cours;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoursRepository extends JpaRepository<Cours, Long> {
}