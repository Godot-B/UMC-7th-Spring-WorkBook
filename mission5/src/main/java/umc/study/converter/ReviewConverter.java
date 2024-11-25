package umc.study.converter;

import umc.study.domain.Review;
import umc.study.web.dto.ReviewRequestDTO;
import umc.study.web.dto.ReviewResponseDTO;

public class ReviewConverter {

    public static ReviewResponseDTO.WriteReviewResultDTO toWriteReviewResultDTO(Review review) {

        return ReviewResponseDTO.WriteReviewResultDTO.builder()
                .reviewId(review.getId())
                .createdAt(review.getCreatedAt())
                .build();
    }

    public static Review toReview(ReviewRequestDTO.WriteReviewDTO request) {
        float starScore = request.getScore() * 0.5f;

        return Review.builder()
                .body(request.getBody())
                .score(starScore)
                .build();
    }

}
