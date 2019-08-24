package com.Desert.Validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Constraint(validatedBy = MatchPasswordValidator.class)
@Target({ElementType.ANNOTATION_TYPE, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MatchPassword {

    String message() default "Password doesn't match!";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
