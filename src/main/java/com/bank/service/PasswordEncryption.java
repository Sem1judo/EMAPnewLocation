package com.bank.service;

import com.lambdaworks.crypto.SCryptUtil;

public class PasswordEncryption {



    public String encriptPassword(String password) {
        return SCryptUtil.scrypt(password, 16, 16, 16);
    }
}
