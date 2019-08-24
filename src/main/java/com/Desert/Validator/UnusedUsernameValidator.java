package com.Desert.Validator;

import com.Desert.Service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
public class UnusedUsernameValidator implements ConstraintValidator<UnusedUsername, String> {

    @Autowired
    private MemberService memberService;

    @Override
    public void initialize(UnusedUsername unusedUsername) {

    }

    @Override
    public boolean isValid(String username, ConstraintValidatorContext constraintValidatorContext) {
        return !memberService.existedUsername(username);
    }
}
