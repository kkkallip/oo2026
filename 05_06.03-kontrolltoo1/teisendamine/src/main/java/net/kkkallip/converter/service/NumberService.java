package net.kkkallip.converter.service;

import lombok.AllArgsConstructor;
import net.kkkallip.converter.entity.Number;
import net.kkkallip.converter.repository.NumberRepository;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class NumberService {

    private NumberRepository numberRepository;
    private NumberConvertingService convertingService;

    public void validateNumber(Number number) {
        if (number.getId() != null) {
            throw new RuntimeException("Cannot have ID when adding!");
        }
        if (number.getNumber() == null) {
            throw new RuntimeException("Number cannot be empty!");
        }
    }

    public String addResult(Integer base, Number number) {
        validateNumber(number);
        return convertingService.convert(base, number.getNumber());
    }
}