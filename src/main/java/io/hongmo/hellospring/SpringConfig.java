package io.hongmo.hellospring;

import io.hongmo.hellospring.repository.MemberRepository;
import io.hongmo.hellospring.repository.MemoryMemberRepository;
import io.hongmo.hellospring.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
}
