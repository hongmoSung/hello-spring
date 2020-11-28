package io.hongmo.hellospring.service;

import io.hongmo.hellospring.domain.Member;
import io.hongmo.hellospring.repository.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {

    MemberService memberService;
    MemoryMemberRepository memberRepository;

    @BeforeEach
    public void beforeEach() {
        memberRepository = new MemoryMemberRepository();
        memberService = new MemberService(memberRepository);
    }

    @AfterEach
    public void clearStore() {
        memberRepository.clearStore();
    }

    @Test
    void join() {
        // given
        Member member = new Member();
        member.setName("spring");

        Long joinedMemberId = memberService.join(member);
        // when
        Member findedMember = memberService.findOne(joinedMemberId).get();
        // then
        assertThat(member.getName()).isEqualTo(findedMember.getName());
    }

    @Test
    void 중복_회원가입_테스트() {
        // given
        Member member = new Member();
        member.setName("spring");

        Member member1 = new Member();
        member1.setName("spring");

        // when
        memberService.join(member);
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member1));
        // then
        assertThat(e.getMessage()).isEqualTo("이미 존재하는 이름입니다.");

    }

    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}