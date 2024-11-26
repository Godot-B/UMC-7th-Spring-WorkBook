package umc.study.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import umc.study.apiPayload.ApiResponse;
import umc.study.converter.MemberMissionConverter;
import umc.study.domain.mapping.MemberMission;
import umc.study.service.MissionService.MemberMissionCommandService;
import umc.study.validation.annotation.NewChallenge;
import umc.study.web.dto.MissionRequestDTO;
import umc.study.web.dto.MissionResponseDTO;

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
