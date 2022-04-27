package com.pjh.core.order;

import com.pjh.core.member.Grade;
import com.pjh.core.member.Member;
import com.pjh.core.member.MemberService;
import com.pjh.core.member.MemberServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.internal.matchers.Or;

public class OrderServiceTest {

    MemberService memberService = new MemberServiceImpl();
    OrderService orderService = new OrderServiceImpl();

    @Test
    void createOrder() {
        Long memberId = 1L;
        Member member = new Member(memberId, "memberB", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemB", 10000);
        Assertions.assertEquals(order.getDiscountPrice(), 1000);
    }
}
