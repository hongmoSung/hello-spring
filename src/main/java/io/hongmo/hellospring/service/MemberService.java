package io.hongmo.hellospring.service;

import io.hongmo.hellospring.domain.Member;
import io.hongmo.hellospring.repository.MemberRepository;
import io.hongmo.hellospring.repository.MemoryMemberRepository;

import java.util.List;
import java.util.Optional;

public class MemberService {

    private final MemberRepository memberRepository = new MemoryMemberRepository();


    public Long join(Member member) {
        validateDuplicateMemberName(member);
        memberRepository.save(member);
        return member.getId();
    }

    public List<Member> findMembers() {
        return memberRepository.selectAll();
    }

    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }

    private void validateDuplicateMemberName(Member member) {
        memberRepository.findByName(member.getName()).ifPresent(m -> {
            throw new IllegalStateException("이미 존재하는 이름입니다.");
        });
    }
}
