package com.harryseong.constraints;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.*;
import java.lang.annotation.*;
import javax.validation.*;

/**
 * Created by harry on 4/17/17.
 */

@Constraint(validatedBy = ISBNValidator.class)  // ISBNValidator contains the validation logic
@Target({ METHOD, FIELD })
@Retention(RUNTIME)
public @interface ISBN {

    String message() default "ISBN NOT VALID!";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };

}