package umc.study.service.StoreService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.study.apiPayload.code.status.ErrorStatus;
import umc.study.apiPayload.exception.handler.StoreHandler;
import umc.study.converter.MissionConverter;
import umc.study.converter.ReviewConverter;
import umc.study.domain.Mission;
import umc.study.domain.Review;
import umc.study.domain.Store;
import umc.study.repository.MissionRepository;
import umc.study.repository.ReviewRepository;
import umc.study.web.dto.MissionRequestDTO;
import umc.study.web.dto.ReviewRequestDTO;

@Service
@RequiredArgsConstructor
public class StoreCommandServiceImpl implements StoreCommandService {

    private final ReviewRepository reviewRepository;
    private final MissionRepository missionRepository;
    private final StoreQueryService storeQueryService;

    @Override
    @Transactional
    public Review createReview(Long storeId, ReviewRequestDTO.WriteReviewDTO request) {

        Store store = storeQueryService.findStore(storeId)
                .orElseThrow(() -> new StoreHandler(ErrorStatus
                        .STORE_NOT_FOUND));

        Review newReview = ReviewConverter.toReview(request);
        newReview.setStore(store);

        return reviewRepository.save(newReview);
    }

    @Override
    @Transactional
    public Mission createMission(Long storeId, MissionRequestDTO.WriteMissionDTO request) {

        Store store = storeQueryService.findStore(storeId)
                .orElseThrow(() -> new StoreHandler(ErrorStatus
                        .STORE_NOT_FOUND));

        Mission newMission = MissionConverter.toMission(request);
        newMission.setStore(store);

        return missionRepository.save(newMission);
    }
}
