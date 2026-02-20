package net.kkkallip.autod.repository;

import net.kkkallip.autod.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Long> {
    //SELECT * FROM car WHERE modelName =
    Car findByModelName(String modelName);
}
