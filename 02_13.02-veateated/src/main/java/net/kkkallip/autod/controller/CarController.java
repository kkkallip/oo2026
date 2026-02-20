package net.kkkallip.autod.controller;

import net.kkkallip.autod.entity.Car;
import net.kkkallip.autod.repository.CarRepository;
import net.kkkallip.autod.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CarController {

    @Autowired
    private CarService carService;

    @Autowired
    private CarRepository carRepository;

    @GetMapping("cars")
    public List<Car> getCars() {
        return carRepository.findAll();
    }

    @DeleteMapping("cars/{id}")
    public List<Car> deleteCar(@PathVariable Long id) {
        carRepository.deleteById(id);
        return carRepository.findAll();
    }

    @PostMapping("cars")
    public Car addCar(@RequestBody Car car) {
        Car dbCar = carRepository.findByModelName(car.getModelName());
        if (dbCar != null) {
            throw new RuntimeException("Cannot add existing car");
        }
        if (car.getId() != null) {
            throw new RuntimeException("Cannot add with ID");
        }
        if (car.getModelName() == null || car.getModelName().isEmpty()) {
            throw new RuntimeException("Cannot add without name");
        }
        if (car.getManufacturer() == null || car.getManufacturer().isEmpty()) {
            throw new RuntimeException("Cannot add without manufacturer");
        }
        if (car.getClassification() == null || car.getClassification().isEmpty()) {
            throw new RuntimeException("Cannot add without car classification");
        }
        return carRepository.save(car);
    }
}
