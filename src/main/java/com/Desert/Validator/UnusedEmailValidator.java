package com.Desert.Validator;

import com.Desert.Service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
public class UnusedEmailValidator implements ConstraintValidator<UnusedEmail, String> {

    @Autowired
    private MemberService memberService;

    @Override
    public void initialize(UnusedEmail unusedEmail) {
    }

    @Override
    public boolean isValid(String email, ConstraintValidatorContext constraintValidatorContext) {
        return !memberService.existedEmail(email);
    }
}
