package umc.study.service.ReviewService;

import umc.study.domain.Review;
import umc.study.web.dto.ReviewRequestDTO;

public interface ReviewCommandService {

    Review createReview(Long storeId, ReviewRequestDTO.WriteDTO request);
}
