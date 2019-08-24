package com.Desert.Validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Constraint(validatedBy = UnusedTitleValidator.class)
@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface UnusedTitle {

    String message() default "This title is used in another content! Please change the title!";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
