package com.example.CrudExercise.repo;

import com.example.CrudExercise.enity.Cars;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryCars extends JpaRepository<Cars , Long> {
}
