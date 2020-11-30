package io.hongmo.hellospring;

import io.hongmo.hellospring.repository.EmployeesRepository;
import io.hongmo.hellospring.repository.MemberRepository;
import io.hongmo.hellospring.service.EmployeesService;
import io.hongmo.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    private final MemberRepository memberRepository;
    private final EmployeesRepository employeesRepository;

    @Autowired
    public SpringConfig(MemberRepository memberRepository, EmployeesRepository employeesRepository) {
        this.memberRepository = memberRepository;
        this.employeesRepository = employeesRepository;
    }

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository);
    }

    @Bean
    public EmployeesService employeesService() {
        return new EmployeesService(employeesRepository);
    }

//    @Bean
//    public MemberRepository memberRepository() {
//        return new MemoryMemberRepository();
//        return new JpaMemberRepository(entityManager);
//    }

}
