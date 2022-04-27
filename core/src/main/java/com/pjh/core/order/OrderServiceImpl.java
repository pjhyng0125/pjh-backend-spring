package com.pjh.core.order;

import com.pjh.core.discount.DiscountPolicy;
import com.pjh.core.discount.FixDiscountPolicy;
import com.pjh.core.member.Member;
import com.pjh.core.member.MemberRepository;
import com.pjh.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService {

    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);
        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
