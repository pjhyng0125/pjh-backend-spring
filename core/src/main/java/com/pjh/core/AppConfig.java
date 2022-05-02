package com.pjh.core;

import com.pjh.core.discount.DiscountPolicy;
import com.pjh.core.discount.FixDiscountPolicy;
import com.pjh.core.discount.RateDiscountPolicy;
import com.pjh.core.member.MemberRepository;
import com.pjh.core.member.MemberService;
import com.pjh.core.member.MemberServiceImpl;
import com.pjh.core.member.MemoryMemberRepository;
import com.pjh.core.order.OrderService;
import com.pjh.core.order.OrderServiceImpl;

public class AppConfig {
    public MemberService memberService() {
        return new MemberServiceImpl(getMemberRepository());
    }

    public OrderService orderService() {
        return new OrderServiceImpl(getMemberRepository(), getDiscountPolicy());
    }

    private MemberRepository getMemberRepository() {
        return new MemoryMemberRepository();
    }

    private DiscountPolicy getDiscountPolicy() {
//        return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }
}
