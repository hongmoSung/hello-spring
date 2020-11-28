package io.hongmo.hellospring;

import io.hongmo.hellospring.repository.JpaMemberRepository;
import io.hongmo.hellospring.repository.MemberRepository;
import io.hongmo.hellospring.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Configuration
public class SpringConfig {

    @PersistenceContext
    private EntityManager entityManager;

    public SpringConfig(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
//        return new MemoryMemberRepository();
        return new JpaMemberRepository(entityManager);
    }

}
