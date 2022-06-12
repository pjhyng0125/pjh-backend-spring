package com.pjh.servlet.web.frontcontroller.v3.controller;

import com.pjh.servlet.basic.domain.member.Member;
import com.pjh.servlet.basic.domain.member.MemberRepository;
import com.pjh.servlet.web.frontcontroller.ModelView;
import com.pjh.servlet.web.frontcontroller.v3.ControllerV3;
import java.util.Map;

public class MemberSaveControllerV3 implements ControllerV3 {

    private MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    public ModelView process(Map<String, String> paramMap) {
        String username = paramMap.get("username");
        int age = Integer.parseInt(paramMap.get("age"));

        Member member = new Member(username, age);
        memberRepository.save(member);

        ModelView mv = new ModelView("save-result");
        mv.getModel().put("member", member);

        return mv;
    }
}
