package com.bank.utility;

import com.bank.service.validator.EmailValidator;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class EmailValidatorTest {

    private String arg;
    private static EmailValidator emailValidator;
    private Boolean expectedValidation;

    public EmailValidatorTest(String str, Boolean expectedValidation) {
        this.arg = str;
        this.expectedValidation = expectedValidation;
    }

    @BeforeClass
    public static void initialize() {
        emailValidator = new EmailValidator();
    }

    @Parameters
    public static Collection<Object[]> data() {
        Object[][] data = new Object[][] {
                {"n!k@s",false },
                { "gregorymarjames-law", false },
                { "AasadDSASa.gmail.com", false },
                { "n!koabcD#AX", false },
                { "ABCASWF2!", false   },

                // valid email
                {"epamKiev@gmail.com",true },
                { "sportsKiev@mail.ru", true },
                { "studyWell@net.com", true } };


        return Arrays.asList(data);
    }

    @Test
    public void test() {
        Boolean res = emailValidator.validate(this.arg);
        String validv = (res) ? "valid" : "invalid";
        System.out.println("Email "+arg+ " is " + validv);
        assertEquals("Result", this.expectedValidation, res);

    }

}
