package com.bank.injector;

import com.bank.domain.User;
import com.bank.repository.UserRepository;
import com.bank.repository.impl.UserRepositoryImpl;
import com.bank.service.PasswordEncryption;
import com.bank.service.UserService;
import com.bank.service.impl.UserServiceImpl;
import com.bank.service.validator.UserValidator;
import com.bank.service.validator.Validator;

public class ApplicationInjector {

    private static final ApplicationInjector INSTANCE = new ApplicationInjector();

    private static final Validator<User> USER_VALIDATOR = new UserValidator();

    private static final PasswordEncryption PASSWORD_ENCRIPTOR = new PasswordEncryption();

    private static final UserRepository USER_REPOSITORY = new UserRepositoryImpl();

    private static final UserService USER_SERVICE = new UserServiceImpl(USER_REPOSITORY, PASSWORD_ENCRIPTOR, USER_VALIDATOR);

    private ApplicationInjector() {
    }

    public static ApplicationInjector getInstance() {
        return INSTANCE;
    }

    public UserService getUserService(){
        return USER_SERVICE;
    }
}
