package com.bank.service;

import com.bank.domain.User;

public interface UserService {

    boolean login(String email, String password);

    User register(User user);
}
