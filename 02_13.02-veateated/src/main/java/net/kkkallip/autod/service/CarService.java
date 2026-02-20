package net.kkkallip.autod.service;

import net.kkkallip.autod.entity.Car;
import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class CarService {

    public void validate(Car car) {
        if (car.getId() != null) {
            throw new RuntimeException("Cannot add with ID");
        }
        if (car.getModelName() == null || car.getModelName().isEmpty()) {
            throw new RuntimeException("Cannot add without name");
        }
        if (car.getManufacturer() == null || car.getManufacturer().isEmpty()) {
            throw new RuntimeException("Cannot add without manufacturer");
        }
    }
}
