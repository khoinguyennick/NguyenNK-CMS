package com.Desert.Validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Constraint(validatedBy = UnusedUsernameValidator.class)
@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface UnusedUsername {

    String message() default "Username already exists!";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
