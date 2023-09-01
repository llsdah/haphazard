package org.example.mvc;

import org.example.mvc.PasswordGenerator;

public class CorrectPasswordGenerator implements PasswordGenerator {
    @Override
    public String generatorPassword() {
        return "12341234";
    }
}
