package com.pjh.hello.hellospring;

import com.pjh.hello.hellospring.repository.MemberRepository;
import com.pjh.hello.hellospring.repository.MemoryMemberRepository;
import com.pjh.hello.hellospring.service.MemberService;
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
