package com.pjh.hello.hellospring.service;

import com.pjh.hello.hellospring.domain.Member;
import com.pjh.hello.hellospring.repository.MemberRepository;
import com.pjh.hello.hellospring.repository.MemoryMemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
class MemberServiceIntegrationTest {

    @Autowired MemberService memberService;
    @Autowired MemberRepository memberRepository;

    @Test
    void 회원가입() {
        //given
        Member m = new Member();
        m.setName("hello2");

        // when
        Long saveId = memberService.join(m);

        // then
        Member findMember = memberService.findOne(saveId).get();

        Assertions.assertEquals(m.getName(), findMember.getName());
    }

    @Test
    public void 중복_화면_예외() {
        //given
        Member m1 = new Member();
        m1.setName("spring");

        Member m2 = new Member();
        m2.setName("spring");

        // when
        memberService.join(m1);
        IllegalStateException e = Assertions.assertThrows(IllegalStateException.class, () -> memberService.join(m2));
        Assertions.assertEquals(e.getMessage(), "이미 존재하는 회원입니다.");
    }
}