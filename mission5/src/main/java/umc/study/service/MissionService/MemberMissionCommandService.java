package umc.study.service.MissionService;

import org.springframework.validation.annotation.Validated;
import umc.study.domain.mapping.MemberMission;
import umc.study.validation.annotation.NewChallenge;
import umc.study.web.dto.MissionRequestDTO;


public interface MemberMissionCommandService {

    boolean alreadyChallenging(MemberMission memberMission);

    MemberMission makeChallenge(Long memberId, Long missionId, MissionRequestDTO.ChangeStatusDTO request);
}