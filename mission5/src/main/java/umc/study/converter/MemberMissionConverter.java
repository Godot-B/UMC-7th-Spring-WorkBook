package umc.study.converter;

import lombok.RequiredArgsConstructor;
import umc.study.domain.Member;
import umc.study.domain.mapping.MemberMission;
import umc.study.service.MemberService.MemberCommandService;
import umc.study.web.dto.MissionRequestDTO;
import umc.study.web.dto.MissionResponseDTO;

import java.time.LocalDateTime;

@RequiredArgsConstructor
public class MemberMissionConverter {

    public static MissionResponseDTO.ChallengeResultDTO challengeResultDTO(MemberMission memberMission) {

        return MissionResponseDTO.ChallengeResultDTO.builder()
                .memberMissionId(memberMission.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static MemberMission toMemberMission(MissionRequestDTO.ChangeStatusDTO request) {
        return MemberMission.builder()
                .status(request.getStatus())
                .build();
    }
}
