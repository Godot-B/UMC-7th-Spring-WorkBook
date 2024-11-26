package umc.study.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import umc.study.apiPayload.ApiResponse;
import umc.study.converter.MissionConverter;
import umc.study.converter.ReviewConverter;
import umc.study.domain.Mission;
import umc.study.domain.Review;
import umc.study.service.StoreService.StoreCommandService;
import umc.study.validation.annotation.ExistStore;
import umc.study.web.dto.MissionRequestDTO;
import umc.study.web.dto.MissionResponseDTO;
import umc.study.web.dto.ReviewRequestDTO;
import umc.study.web.dto.ReviewResponseDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/map/store")
@Validated
public class StoreRestController {

    private final StoreCommandService storeCommandService;

    @PostMapping("/{storeId}/new-mission")
    public ApiResponse<MissionResponseDTO.WriteMissionResultDTO> writeMission(
            @PathVariable @ExistStore Long storeId, @RequestBody @Valid MissionRequestDTO.WriteMissionDTO request) {

        Mission mission = storeCommandService.createMission(storeId, request);
        return ApiResponse.onSuccess(MissionConverter.toWriteMissionResultDTO(mission));
    }

    @PostMapping("/{storeId}/reviews/new")
    public ApiResponse<ReviewResponseDTO.WriteReviewResultDTO> writeReview(
            @PathVariable @ExistStore Long storeId, @RequestBody @Valid ReviewRequestDTO.WriteReviewDTO request) {

        Review review = storeCommandService.createReview(storeId, request);
        return ApiResponse.onSuccess(ReviewConverter.toWriteReviewResultDTO(review));
    }
}
