package umc.study.converter;

import umc.study.domain.Review;
import umc.study.web.dto.ReviewRequestDTO;
import umc.study.web.dto.ReviewResponseDTO;

public class ReviewConverter {

    public static ReviewResponseDTO.WriteResultDTO toWriteResultDTO(Review review) {

        return ReviewResponseDTO.WriteResultDTO.builder()
                .reviewId(review.getId())
                .build();
    }

    public static Review toReview(ReviewRequestDTO.WriteDTO request) {
        float starScore = request.getScore() * 0.5f;

        return Review.builder()
                .body(request.getBody())
                .score(starScore)
                .build();
    }

}
