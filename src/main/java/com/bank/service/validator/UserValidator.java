package com.bank.service.validator;

import com.bank.domain.User;

public class UserValidator implements Validator<User> {
    PasswordValidator passwordValidator;
    EmailValidator emailValidator;

    /*
    Be between 8 and 40 characters long
    Contain at least one digit.
    Contain at least one lower case character.
    Contain at least one upper case character.
    Contain at least on special character from [ @ # $ % ! . ].
    */

    @Override
    public void validate(User entity) {
        if (passwordValidator.validate(entity.getPassword()) && emailValidator.validate(entity.getEmail())) {
            System.out.println("Validation passed");
        } else throw new RuntimeException("Validation not passed");


    }
}
