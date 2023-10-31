package top.imono.jk.common.validator;

import jakarta.validation.Constraint;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Constraint(validatedBy = {BoolNumber.BoolNumberValidator.class, BoolNumber.BoolNumberShortValidator.class })
public @interface BoolNumber {
    String message() default "只能是0或1";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

     class BoolNumberValidator implements ConstraintValidator<BoolNumber, Integer>{
         @Override
         public boolean isValid(Integer num, ConstraintValidatorContext constraintValidatorContext) {
             return  num == null || num == 0 || num == 1;
         }
     }

    class BoolNumberShortValidator implements ConstraintValidator<BoolNumber, Short>{
        @Override
        public boolean isValid(Short num, ConstraintValidatorContext constraintValidatorContext) {
            return  num == null || num == 0 || num == 1;
        }
    }
}
