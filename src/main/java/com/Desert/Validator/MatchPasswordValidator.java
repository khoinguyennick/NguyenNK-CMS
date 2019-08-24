package com.Desert.Validator;

import com.Desert.Model.RegisterModel;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class MatchPasswordValidator implements ConstraintValidator<MatchPassword, RegisterModel> {

    private String message;

    @Override
    public void initialize(MatchPassword matchPassword) {
        this.message = matchPassword.message();
    }

    @Override
    public boolean isValid(RegisterModel registerModel, ConstraintValidatorContext context) {
        String password = registerModel.getPassword();
        String rePassword = registerModel.getRePassword();

        boolean valid = !(password == null) && !(rePassword == null) && password.equals(rePassword);
        if (!valid) {
            context.buildConstraintViolationWithTemplate(message)
                    .addPropertyNode("rePassword")
                    .addConstraintViolation()
                    .disableDefaultConstraintViolation();
        }

        return valid;
    }
}
