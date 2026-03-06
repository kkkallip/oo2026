package net.kkkallip.converter.controller;

import lombok.AllArgsConstructor;
import net.kkkallip.converter.entity.Number;
import net.kkkallip.converter.repository.NumberRepository;
import net.kkkallip.converter.service.NumberService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class NumberController {

    private NumberRepository numberRepository;
    private NumberService numberService;

    @GetMapping("numbers")
    public List<Number> getNumbers() {
        return numberRepository.findAll();
    }

    @PostMapping("numbers")
    public List<Number> addNumber(@RequestBody Number number) {
        numberService.validateNumber(number);
        numberRepository.save(number);
        return numberRepository.findAll();
    }

    @PostMapping("convert/{base}")
    public String convert(@PathVariable Integer base, @RequestBody Number result) {
        return numberService.addResult(base, result);
    }
}