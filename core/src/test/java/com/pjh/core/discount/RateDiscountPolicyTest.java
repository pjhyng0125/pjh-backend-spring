package com.pjh.core.discount;

import com.pjh.core.member.Grade;
import com.pjh.core.member.Member;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RateDiscountPolicyTest {
    RateDiscountPolicy discountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("VIP는 10% 할인이 적용되어야 한다")
    void vip_o() {
        Member memberVIP = new Member(1L, "memberVIP", Grade.VIP);

        int discount = discountPolicy.discount(memberVIP, 20000);
        assertEquals(2000, discount);
    }

    @Test
    @DisplayName("BASIC은 10% 할인이 적용되지 않아야 한다")
    void vip_x() {
        Member memberBASIC = new Member(1L, "memberBASIC", Grade.BASIC);

        int discount = discountPolicy.discount(memberBASIC, 10000);
        assertEquals(0, discount);
//        Assertions.assertEquals(1000, discount);
    }
}