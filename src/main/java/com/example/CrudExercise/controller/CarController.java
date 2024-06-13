package com.example.CrudExercise.controller;

import com.example.CrudExercise.enity.Cars;
import com.example.CrudExercise.repo.RepositoryCars;
import com.example.CrudExercise.services.ServicesCar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/car")
public class CarController {
    @Autowired
    private ServicesCar services;

    @PostMapping("/insert")
    public Cars createCar(@RequestBody Cars cars) {
        return services.saveCar(cars);
    }

    @GetMapping("/getAllCars")
    public List<Cars> getListOfCars() {
        return services.returnAllCars();
    }

    @GetMapping("/{id}")
    public Optional<Cars> showCarById(@PathVariable long id) {
        return services.returnCarById(id);
    }

    @PutMapping("/{id}")
    public Cars changeTypeOfCarById(@PathVariable long id, @RequestParam(required = false) String type) {
        return services.changeTypeById(id, type);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity.BodyBuilder deleteThisCar(@PathVariable long id) throws ClassNotFoundException {
        try {
            services.deleteByID(id);
            return ResponseEntity.status(HttpStatus.ACCEPTED);
        } catch (ClassNotFoundException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT);
        }
    }

    @DeleteMapping("/clearAll")
    public void deleteAllCars() {
        services.deleteAll();
    }
}
