package umc.study.web.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;

public class ReviewRequestDTO {

    @Getter
    public static class WriteReviewDTO {

        @Size(min = 5, max = 50)
        String body;

        @NotNull
        Integer score;
    }
}
