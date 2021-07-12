package com.valid.utils;

import com.valid.rules.PassportValidation;
import com.valid.rules.SomeValidation;
import com.valid.rules.Validation;

public class ValidationClasses {
    private static class Classes {
        final static String PASSPORT = "Passport";
        final static String SOME = "Some";
    }

    public static boolean validation(String clazz, String method, String value) {
        Validation validation = getValidationClass(clazz);
        assert validation != null;
        return validation.validation(value, method);
    }

    private static Validation getValidationClass(String clazz) {
        Validation validation;
        switch (clazz) {
            case (Classes.PASSPORT):
                validation = new PassportValidation();
                return validation;
            case (Classes.SOME):
                validation = new SomeValidation();
                return validation;
            default:
                return null;
        }
    }

}
