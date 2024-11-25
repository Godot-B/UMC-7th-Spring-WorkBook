package umc.study.service.StoreService;

import umc.study.domain.Mission;
import umc.study.domain.Review;
import umc.study.web.dto.MissionRequestDTO;
import umc.study.web.dto.ReviewRequestDTO;

public interface StoreCommandService {

    Review createReview(Long storeId, ReviewRequestDTO.WriteReviewDTO request);

    Mission createMission(Long storeId, MissionRequestDTO.WriteMissionDTO request);
}
