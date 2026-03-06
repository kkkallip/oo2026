package net.kkkallip.converter.service;

import org.springframework.stereotype.Service;

@Service
public class NumberConvertingService {

    public String convert(int base, int value) {
        return switch (base) {
            case 2 -> Integer.toBinaryString(value);
            case 8 -> Integer.toOctalString(value);
            case 16 -> Integer.toHexString(value);
            default -> throw new IllegalStateException("Unsupported base: " + base + ". Use either base2, base8 or base16!");
        };
    }
}