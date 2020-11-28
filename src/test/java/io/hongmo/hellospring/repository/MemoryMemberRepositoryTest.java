package io.hongmo.hellospring.repository;

import io.hongmo.hellospring.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

class MemoryMemberRepositoryTest {

    MemoryMemberRepository memberRepository = new MemoryMemberRepository();

    @AfterEach
    public void afterEach() {
        memberRepository.clearStore();
    }

    @Test
    public void save() {
        Member member = new Member();
        member.setName("spring");

        memberRepository.save(member);
        Member member1 = memberRepository.findById(member.getId()).get();
        Assertions.assertThat(member).isEqualTo(member1);
    }

    @Test
    public void findByName() {
        Member member = new Member();
        member.setName("spring1");
        memberRepository.save(member);

        Member member1 = new Member();
        member1.setName("spring2");
        memberRepository.save(member1);

        Member result = memberRepository.findByName("spring1").get();
        Assertions.assertThat(member).isEqualTo(result);
    }

    @Test
    public void findAll() {
        Member member = new Member();
        member.setName("spring1");
        memberRepository.save(member);

        Member member1 = new Member();
        member1.setName("spring2");
        memberRepository.save(member1);

        List<Member> memberList = memberRepository.selectAll();
        Assertions.assertThat(memberList.size()).isEqualTo(2);
    }
}
