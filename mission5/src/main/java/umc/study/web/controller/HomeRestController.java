package umc.study.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import umc.study.apiPayload.ApiResponse;
import umc.study.converter.MemberMissionConverter;
import umc.study.converter.ReviewConverter;
import umc.study.domain.Review;
import umc.study.domain.mapping.MemberMission;
import umc.study.service.MissionService.MemberMissionCommandService;
import umc.study.validation.annotation.ExistStore;
import umc.study.validation.annotation.NewChallenge;
import umc.study.web.dto.MissionRequestDTO;
import umc.study.web.dto.MissionResponseDTO;
import umc.study.web.dto.ReviewResponseDTO;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/home")
@Validated
public class HomeRestController {

    private final MemberMissionCommandService memberMissionCommandService;

    @PostMapping("/{userId}/my-mission/{missionId}")
    public ApiResponse<MissionResponseDTO.ChallengeResultDTO> challenge(
            @PathVariable Long userId,
            @PathVariable Long missionId,
            @RequestBody @Valid MissionRequestDTO.ChangeStatusDTO request) {

        MemberMission memberMission = memberMissionCommandService.makeChallenge(userId, missionId, request);

        return ApiResponse.onSuccess(MemberMissionConverter.challengeResultDTO(memberMission));
    }
}
