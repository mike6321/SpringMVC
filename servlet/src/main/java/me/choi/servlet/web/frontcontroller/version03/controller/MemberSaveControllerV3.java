package me.choi.servlet.web.frontcontroller.version03.controller;

import me.choi.servlet.domain.member.Member;
import me.choi.servlet.domain.member.MemberRepository;
import me.choi.servlet.web.frontcontroller.ModelView;
import me.choi.servlet.web.frontcontroller.version03.ControllerV3;

import java.util.Map;

/**
 * Project : servlet
 *
 * @author : jwdeveloper
 * @comment :
 * Time : 9:34 오후
 */
public class MemberSaveControllerV3 implements ControllerV3 {

    private final MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    public ModelView process(final Map<String, String> paramMap) {

        final String username = paramMap.get("username");
        final int age = Integer.parseInt(paramMap.get("age"));

        final Member member = new Member(username, age);
        memberRepository.save(member);
        final ModelView mv = new ModelView("save-result");
        mv.getModel().put("member", member);

        return mv;
    }
}
