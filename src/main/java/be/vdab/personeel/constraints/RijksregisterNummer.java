package be.vdab.personeel.constraints;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Retention(RUNTIME)
@Target({FIELD, METHOD, ANNOTATION_TYPE, TYPE })
@Constraint(validatedBy = RijksregisterNummerValidator.class)
public @interface RijksregisterNummer
{
    String message() default "{be.vdab.personeel.constraints.RijksregisterNummer.message}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
