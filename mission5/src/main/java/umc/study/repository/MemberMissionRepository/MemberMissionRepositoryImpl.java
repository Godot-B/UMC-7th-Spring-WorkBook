package umc.study.repository.MemberMissionRepository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import umc.study.domain.Member;
import umc.study.domain.Mission;
import umc.study.domain.mapping.MemberMission;
import umc.study.domain.mapping.QMemberMission;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class MemberMissionRepositoryImpl implements MemberMissionRepositoryCustom {

    private final JPAQueryFactory queryFactory;
    private final QMemberMission memberMission = QMemberMission.memberMission;

    public List<MemberMission> findByMemberAndMission(Member member, Mission mission) {

        return queryFactory.selectFrom(memberMission)
                .where(
                        memberMission.member.eq(member)
                                .and(memberMission.mission.eq(mission))
                )
                .fetch();
    }
}
