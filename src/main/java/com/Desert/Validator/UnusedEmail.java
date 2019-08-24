package com.Desert.Validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Constraint(validatedBy = UnusedEmailValidator.class)
@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface UnusedEmail {

    String message() default "This email is used by an account!";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
