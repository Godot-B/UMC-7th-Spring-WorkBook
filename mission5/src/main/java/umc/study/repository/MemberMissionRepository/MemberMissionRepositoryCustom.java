package umc.study.repository.MemberMissionRepository;

import umc.study.domain.Member;
import umc.study.domain.Mission;
import umc.study.domain.mapping.MemberMission;

import java.util.List;


public interface MemberMissionRepositoryCustom {

    List<MemberMission> findByMemberAndMission(Member member, Mission mission);
}
