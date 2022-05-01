package com.pjh.core.member;

import com.pjh.core.AppConfig;
import com.pjh.core.member.Grade;
import com.pjh.core.member.Member;
import com.pjh.core.member.MemberService;
import com.pjh.core.member.MemberServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MemberServiceTest {
//    MemberService memberService = new MemberServiceImpl();
    MemberService memberService;

    @BeforeEach
    public void beforeEach() {
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
    }

    @Test
    void join() {
        // given
        Member m = new Member(1L, "memberA", Grade.VIP);

        // when
        memberService.join(m);
        Member fm = memberService.findMember(1L);

        // then
        Assertions.assertEquals(m, fm);
    }
}
