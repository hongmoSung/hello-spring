package io.hongmo.hellospring.service;

import io.hongmo.hellospring.domain.Member;
import io.hongmo.hellospring.repository.MemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class MemberServiceTest {

    @Autowired
    MemberService memberService;
    @Autowired
    MemberRepository memberRepository;

    @Test
    void 회원가입() {
        // given
        Member member = new Member();
        member.setName("spring100");

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