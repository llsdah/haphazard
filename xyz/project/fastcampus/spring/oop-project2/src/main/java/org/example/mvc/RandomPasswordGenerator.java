package org.example.mvc;

import org.passay.CharacterData;
import org.passay.CharacterRule;
import org.passay.EnglishCharacterData;
import org.passay.PasswordGenerator;

public class RandomPasswordGenerator implements org.example.mvc.PasswordGenerator {
    public static final String ALLOWED_SPL_CHARACTERS = "!@#$%^&*()_+";
    public static final String ERROR_CODE = "ERRONEOUS_SPECIAL_CHARS";

    public String generatorPassword(){
        PasswordGenerator gen = new PasswordGenerator();

        CharacterData lowerCaseChars = EnglishCharacterData.LowerCase;
        CharacterRule lowerCaseRule = new CharacterRule(lowerCaseChars);
        lowerCaseRule.setNumberOfCharacters(2);

        CharacterData upperCaseChars = EnglishCharacterData.UpperCase;
        CharacterRule upperCaseRule = new CharacterRule(upperCaseChars);
        upperCaseRule.setNumberOfCharacters(2);

        CharacterData digitChars = EnglishCharacterData.Digit;
        CharacterRule digitRule = new CharacterRule(digitChars);
        digitRule.setNumberOfCharacters(2);

        CharacterData specificChars = new CharacterData() {
            public String getErrorCode(){
                return ERROR_CODE;
            }
            public String getCharacters(){
                return ALLOWED_SPL_CHARACTERS;
            }
        };

        CharacterRule sqlCharRule = new CharacterRule(specificChars);
        sqlCharRule.setNumberOfCharacters(2);

        return gen.generatePassword((int)(Math.random()*13), sqlCharRule, lowerCaseRule, upperCaseRule, digitRule);
    }

}
