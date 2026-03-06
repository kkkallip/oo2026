package net.kkkallip.converter.repository;

import net.kkkallip.converter.entity.Number;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NumberRepository extends JpaRepository<Number, Long> {
}