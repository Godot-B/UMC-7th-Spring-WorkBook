package umc.study.validation.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import umc.study.validation.validator.ChallengeNotExistValidator;
import umc.study.validation.validator.StoreExistValidator;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = ChallengeNotExistValidator.class)
@Target( {ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER} )
@Retention(RetentionPolicy.RUNTIME)
public @interface NewChallenge {

    String message() default "이미 도전 중인 미션입니다.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
