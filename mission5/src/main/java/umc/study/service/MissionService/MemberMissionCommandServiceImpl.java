package umc.study.service.MissionService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import umc.study.apiPayload.code.status.ErrorStatus;
import umc.study.apiPayload.exception.handler.MemberHandler;
import umc.study.apiPayload.exception.handler.MissionHandler;
import umc.study.converter.MemberMissionConverter;
import umc.study.domain.Member;
import umc.study.domain.Mission;
import umc.study.domain.enums.MissionStatus;
import umc.study.domain.mapping.MemberMission;
import umc.study.repository.MemberMissionRepository.MemberMissionRepository;
import umc.study.repository.MemberRepository;
import umc.study.repository.MissionRepository;
import umc.study.validation.annotation.NewChallenge;
import umc.study.web.dto.MissionRequestDTO;


@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
@Validated
public class MemberMissionCommandServiceImpl implements MemberMissionCommandService {

    private final MemberMissionRepository memberMissionRepository;
    private final MemberRepository memberRepository;
    private final MissionRepository missionRepository;

    @Override
    public boolean alreadyChallenging(MemberMission memberMission) {
        return memberMissionRepository
                .findByMemberAndMission(memberMission.getMember(), memberMission.getMission())
                .stream()
                .filter(mMission -> mMission.getStatus() == MissionStatus.CHALLENGING)
                .count() != 1;
    }

    @Override
    @Transactional
    @NewChallenge
    public MemberMission makeChallenge(Long memberId, Long missionId, MissionRequestDTO.ChangeStatusDTO request) {

        Member member = memberRepository.findById(memberId).orElseThrow(() -> new MemberHandler(ErrorStatus.MEMBER_NOT_FOUND));
        Mission mission = missionRepository.findById(missionId).orElseThrow(() -> new MissionHandler(ErrorStatus.MISSION_NOT_FOUND));
        MemberMission newMemberMission = MemberMissionConverter.toMemberMission(request);

        newMemberMission.setMember(member);
        newMemberMission.setMission(mission);

        return memberMissionRepository.save(newMemberMission);
    }
}
