package umc.study.service.MemberService;

import umc.study.domain.Member;
import umc.study.web.dto.MemberRequestDTO;

import java.util.Optional;

public interface MemberCommandService {

    Member joinMember(MemberRequestDTO.JoinDTO request);
}