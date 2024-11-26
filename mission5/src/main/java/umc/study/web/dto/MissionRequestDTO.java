package umc.study.web.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import umc.study.domain.enums.MissionStatus;
import umc.study.validation.annotation.NewChallenge;

import java.time.LocalDate;

public class MissionRequestDTO {

    @Getter
    public static class WriteMissionDTO {

        @NotNull
        Integer reward;

        @NotNull
        LocalDate deadline;

        @Size(min = 5, max = 50)
        String missionSpec;
    }

    @Getter
    public static class ChangeStatusDTO {

        @NotNull
        MissionStatus status;
    }
}
