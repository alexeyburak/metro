package com.burak.metro.validator;

import com.burak.metro.annotation.PasswordValid;
import lombok.SneakyThrows;
import org.passay.*;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.constraints.Min;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

/**
 * metro
 * Created by Alexey Burak
 * Nov 2022
 */

public class PasswordConstraintValidator implements ConstraintValidator<PasswordValid, String> {

    @Override
    public void initialize(PasswordValid constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @SneakyThrows
    @Override
    public boolean isValid(final String password, ConstraintValidatorContext constraintValidatorContext) {
        Properties properties = new Properties();
        InputStream inputStream = getClass()
                .getClassLoader().getResourceAsStream("passay.properties");
        properties.load(inputStream);
        PropertiesMessageResolver propertiesMessageResolver = new PropertiesMessageResolver(properties);

        PasswordValidator passwordValidator = new PasswordValidator(propertiesMessageResolver,
                Arrays.asList(
                    new CharacterRule(EnglishCharacterData.LowerCase, 1),
                    new CharacterRule(EnglishCharacterData.Digit, 1),
                    new WhitespaceRule(),
                    new IllegalSequenceRule(EnglishSequenceData.Alphabetical, 4, false),
                    new IllegalSequenceRule(EnglishSequenceData.Numerical, 4, false)
                )
        );

        RuleResult ruleResult = passwordValidator.validate(new PasswordData(password));
        if (ruleResult.isValid()) {
            return true;
        }

        List<String> validatorMessages = passwordValidator.getMessages(ruleResult);
        String messageTemplate = String.join("\n", validatorMessages);
        constraintValidatorContext
                .buildConstraintViolationWithTemplate(messageTemplate)
                .addConstraintViolation()
                .disableDefaultConstraintViolation();
        return false;
    }
}
