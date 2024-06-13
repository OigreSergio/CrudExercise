package com.example.CrudExercise.services;

import ch.qos.logback.classic.spi.IThrowableProxy;
import com.example.CrudExercise.enity.Cars;
import com.example.CrudExercise.repo.RepositoryCars;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServicesCar {
    @Autowired
    private RepositoryCars repository;

    public Cars saveCar(Cars cars) {
        return repository.save(cars);
    }

    public List<Cars> returnAllCars() {
        return repository.findAll();
    }

    public Optional<Cars> returnCarById(long id) {
        if (!repository.existsById(id)) {
            return Optional.of(new Cars());
        }
        return repository.findById(id);
    }

    public Cars changeTypeById(long id, String type) {
        if (!repository.existsById(id)) {
            return new Cars();
        }
        Cars carChanged = repository.getReferenceById(id);
        carChanged.setType(type);
        return repository.save(carChanged);
    }
    public void deleteByID(long id)throws ClassNotFoundException{
        if(!repository.existsById(id)){
            throw new ClassNotFoundException("There is mo car whit this id in our garage");
        }
        repository.deleteById(id);
    }
    public void deleteAll(){
        repository.deleteAll();
    }
}
