package com.bank.service.impl;

import com.bank.domain.User;
import com.bank.repository.UserRepository;
import com.bank.service.PasswordEncriptor;
import com.bank.service.UserService;
import com.bank.service.validator.UserValidator;
import com.bank.service.validator.Validator;

public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncriptor passwordEncriptor;
    private final Validator<User> userValidator;

    public UserServiceImpl(UserRepository userRepository, PasswordEncriptor passwordEncriptor,
                           Validator<User> userValidator) {
        this.userRepository = userRepository;
        this.passwordEncriptor = passwordEncriptor;
        this.userValidator = userValidator;
    }

    @Override
    public boolean login(String email, String password) {
        String encriptPassword = passwordEncriptor.encript(password);

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
