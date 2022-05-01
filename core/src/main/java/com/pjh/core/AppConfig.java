package com.pjh.core;

import com.pjh.core.discount.FixDiscountPolicy;
import com.pjh.core.member.MemberService;
import com.pjh.core.member.MemberServiceImpl;
import com.pjh.core.member.MemoryMemberRepository;
import com.pjh.core.order.OrderService;
import com.pjh.core.order.OrderServiceImpl;

public class AppConfig {
    public MemberService memberService() {
        return new MemberServiceImpl(new MemoryMemberRepository());
    }

    public OrderService orderService() {
        return new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPolicy());
    }
}
