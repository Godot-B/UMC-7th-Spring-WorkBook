package umc.study.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import umc.study.apiPayload.ApiResponse;
import umc.study.apiPayload.code.status.ErrorStatus;
import umc.study.apiPayload.exception.handler.FoodCategoryHandler;
import umc.study.converter.ReviewConverter;
import umc.study.domain.Member;
import umc.study.domain.Review;
import umc.study.service.MemberService.MemberCommandService;
import umc.study.service.ReviewService.ReviewCommandService;
import umc.study.validation.annotation.ExistStore;
import umc.study.web.dto.ReviewRequestDTO;
import umc.study.web.dto.ReviewResponseDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/map/store/{storeId}")
public class ReviewRestController {

    private final ReviewCommandService reviewCommandService;

    @PostMapping("/reviews/new")
    public ApiResponse<ReviewResponseDTO.WriteResultDTO> writeReview(
            @PathVariable @ExistStore Long storeId, @RequestBody @Valid ReviewRequestDTO.WriteDTO request) {

        Review review = reviewCommandService.createReview(storeId, request);
        return ApiResponse.onSuccess(ReviewConverter.toWriteResultDTO(review));
    }
}
