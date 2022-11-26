package com.burak.metro.validator;

import com.burak.metro.annotation.UsernameValid;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * metro
 * Created by Alexey Burak
 * Nov 2022
 */

public class UsernameConstraintValidator implements ConstraintValidator<UsernameValid, String> {

    @Override
    public void initialize(UsernameValid constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(final String username, ConstraintValidatorContext constraintValidatorContext) {
        final int USERNAME_LENGTH_MIN = 3;
        final int USERNAME_LENGTH_MAX = 15;

        boolean isUsernameLengthValid = username.length() > USERNAME_LENGTH_MIN && username.length() < USERNAME_LENGTH_MAX;
        if (!isUsernameLengthValid) {
            constraintValidatorContext.disableDefaultConstraintViolation();
            constraintValidatorContext
                    .buildConstraintViolationWithTemplate("Username must be between 3 and 15 characters")
                    .addConstraintViolation();
        }
        return isUsernameLengthValid;
    }
}
