package umc.study.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.study.apiPayload.code.status.ErrorStatus;
import umc.study.domain.mapping.MemberMission;
import umc.study.service.MissionService.MemberMissionCommandService;
import umc.study.validation.annotation.NewChallenge;

@Component
@RequiredArgsConstructor
public class ChallengeNotExistValidator implements ConstraintValidator<NewChallenge, MemberMission> {

    private final MemberMissionCommandService memberMissionCommandService;

    @Override
    public void initialize(NewChallenge constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(MemberMission memberMission, ConstraintValidatorContext context) {

        boolean isNotValid = memberMissionCommandService.alreadyChallenging(memberMission);

        if (isNotValid) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.MISSION_ALREADY_CHALLENGING.toString())
                    .addConstraintViolation();
        }

        return !isNotValid;
    }
}
