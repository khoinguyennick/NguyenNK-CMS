package com.Desert.Validator;

import com.Desert.Service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
public class UnusedTitleValidator implements ConstraintValidator<UnusedTitle, String> {

    @Autowired
    private ContentService contentService;

    @Override
    public void initialize(UnusedTitle unusedTitle) {

    }

    @Override
    public boolean isValid(String title, ConstraintValidatorContext constraintValidatorContext) {
        return !contentService.existedTitle(title);
    }
}
