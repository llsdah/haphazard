package org.example;

import java.security.spec.PSSParameterSpec;

public class User {

    private String password;

    public void initPassword(PasswordGenerator passwordGenerator){
        
        // 기존방식 : 강한 결합
        //RandomPasswordGenerator randomPasswordGenerator = new RandomPasswordGenerator();
        
        // 수정방식 : 약한 결합
        String randomPassword = passwordGenerator.generatorPassword();

        /**
         * 비밀번호 최소 테스트 입니다.
         */
        if(randomPassword.length() >= 8 && randomPassword.length() <= 12){
            this.password =randomPassword;
        }
    }

    public String getPassword(){
        return this.password;
    }
}
