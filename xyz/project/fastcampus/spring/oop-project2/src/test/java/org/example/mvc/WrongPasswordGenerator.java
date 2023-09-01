package org.example.mvc;

import org.example.mvc.PasswordGenerator;

public class WrongPasswordGenerator implements PasswordGenerator {
    @Override
    public String generatorPassword() {
        return "123";
    }
}
