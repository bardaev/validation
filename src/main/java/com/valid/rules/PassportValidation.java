package com.valid.rules;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class PassportValidation implements Validation {
    @Override
    public boolean validation(String value, String method) {
        try {
            Method method1 = PassportValidation.class.getMethod(method);
            return (boolean) method1.invoke(this, new Object[] {value});
        } catch (NoSuchMethodException e) {
            return false;
        } catch (InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return false;
    }

    private boolean code(String code) {
        return true;
    }

    private boolean number(String number) {
        return true;
    }
}
