package com.pjh.hello.hellospring.service;

import com.pjh.hello.hellospring.domain.Member;
//import org.assertj.core.api.Assertions;
import com.pjh.hello.hellospring.repository.MemoryMemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MemberServiceTest {

    MemberService memberService;
    MemoryMemberRepository memberRepository;

    @BeforeEach
    public void 초기화() {
        memberRepository = new MemoryMemberRepository();
        // DI : Dependency Injection (외부 주입)
        memberService = new MemberService(memberRepository);
    }

    @AfterEach
    public void 저장소_클리어() {
        memberRepository.clearStore();
    }

    @Test
    void 회원가입() {
        //given
        Member m = new Member();
        m.setName("spring");

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
//        try {
//            memberService.join(m2);
//            // fail();
//        } catch (IllegalStateException e) {
//            Assertions.assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
//        }

        //then

    }

    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}