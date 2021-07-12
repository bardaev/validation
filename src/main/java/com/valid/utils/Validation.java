package com.valid.utils;

import com.valid.model.YamlClassMethodValidation;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Validation {

    public static void validation(Map<String, List<YamlClassMethodValidation>> rules, Map<String, String> json) {
        List<YamlClassMethodValidation> listRules = new ArrayList<>();

        rules.forEach((k, v) -> {
            listRules.addAll(v);
        });

        listRules.forEach((v) -> {
//            System.out.println(v.getValidationMethod());
//            System.out.println(v.getField());
//            System.out.println(v.getValidationClass());

            if (json.containsKey(v.getField())) {
                System.out.println(ValidationClasses.validation(v.getValidationClass(), v.getValidationMethod(), json.get(v.getField())));
//                try {
//                    Class<?> clazz = Class.forName(v.getValidationClass());
//                    Constructor<?> con = clazz.getConstructor();
//                    Object obj = con.newInstance();
//                    System.out.println(obj instanceof Passport);
//                    Method method = obj.getDeclaredMethod(v.getValidationMethod());
//                    method.setAccessible(true);
//                    boolean res = (boolean) method.invoke(Validation.class, json.get(v.getValidationMethod()));
//                    Passport passport = (Passport) clazz.newInstance();
//
//                    Method method = passport.getClass().getMethod(v.getValidationMethod());
//                    boolean result = (boolean) method.invoke(Validation.class, json.get(v.getField()));
//                    System.out.println(res);
//                } catch (ClassNotFoundException | NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
//                    e.printStackTrace();
//                }

//                json.get(v.getField());
            }
        });
    }
}
