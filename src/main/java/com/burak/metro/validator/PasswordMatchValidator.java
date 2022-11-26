package com.burak.metro.validator;

import com.burak.metro.annotation.PasswordMatch;
import com.burak.metro.dto.UserDTO;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * metro
 * Created by Alexey Burak
 * Nov 2022
 */

public class PasswordMatchValidator implements ConstraintValidator<PasswordMatch, UserDTO> {

    @Override
    public void initialize(PasswordMatch constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(UserDTO userDTO, ConstraintValidatorContext constraintValidatorContext) {
        boolean isUserPasswordMatchingConfirmPassword = userDTO.getPassword().equals(userDTO.getConfirmPassword());
        if (!isUserPasswordMatchingConfirmPassword) {
            constraintValidatorContext.disableDefaultConstraintViolation();
            constraintValidatorContext
                    .buildConstraintViolationWithTemplate("Passwords should match")
                    .addPropertyNode("confirmPassword").addConstraintViolation();
        }
        return isUserPasswordMatchingConfirmPassword;
    }
}
