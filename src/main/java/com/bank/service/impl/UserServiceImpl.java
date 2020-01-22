package com.bank.service.impl;

import com.bank.domain.User;
import com.bank.repository.UserRepository;
import com.bank.service.PasswordEncryption;
import com.bank.service.UserService;
import com.bank.service.validator.Validator;

public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncryption passwordEncryption;
    private final Validator<User> userValidator;

    public UserServiceImpl(UserRepository userRepository, PasswordEncryption passwordEncryption,
                           Validator<User> userValidator) {
        this.userRepository = userRepository;
        this.passwordEncryption = passwordEncryption;
        this.userValidator = userValidator;
    }

    @Override
    public boolean login(String email, String password) {
        String encriptPassword = passwordEncryption.encriptPassword(password);

        return userRepository.findByEmail(email)
                .map(user -> user.getPassword())
                .filter(pass -> pass.equals(encriptPassword))
                .isPresent();
    }

    @Override
    public User register(User user){
        userValidator.validate(user);

        userRepository.save(user);

        //id?
        return user;
    }
}
