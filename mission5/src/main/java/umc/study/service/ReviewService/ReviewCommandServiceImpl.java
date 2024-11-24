package umc.study.service.ReviewService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.study.apiPayload.code.status.ErrorStatus;
import umc.study.apiPayload.exception.handler.StoreHandler;
import umc.study.converter.ReviewConverter;
import umc.study.domain.Review;
import umc.study.domain.Store;
import umc.study.repository.ReviewRepository;
import umc.study.service.StoreService.StoreQueryService;
import umc.study.web.dto.ReviewRequestDTO;

@Service
@RequiredArgsConstructor
public class ReviewCommandServiceImpl implements ReviewCommandService {

    private final ReviewRepository reviewRepository;
    private final StoreQueryService storeQueryService;

    @Override
    @Transactional
    public Review createReview(Long storeId, ReviewRequestDTO.WriteDTO request) {

        Store store = storeQueryService.findStore(storeId)
                .orElseThrow(() -> new StoreHandler(ErrorStatus
                        .STORE_NOT_FOUND));

        Review newReview = ReviewConverter.toReview(request);
        newReview.setStore(store);

        return reviewRepository.save(newReview);
    }
}
