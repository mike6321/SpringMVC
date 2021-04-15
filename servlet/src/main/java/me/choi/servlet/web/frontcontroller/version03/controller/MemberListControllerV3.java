package me.choi.servlet.web.frontcontroller.version03.controller;

import me.choi.servlet.domain.member.Member;
import me.choi.servlet.domain.member.MemberRepository;
import me.choi.servlet.web.frontcontroller.ModelView;
import me.choi.servlet.web.frontcontroller.version03.ControllerV3;

import java.util.List;
import java.util.Map;

/**
 * Project : servlet
 *
 * @author : jwdeveloper
 * @comment :
 * Time : 9:37 오후
 */
public class MemberListControllerV3 implements ControllerV3 {

    private final MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    public ModelView process(final Map<String, String> paramMap) {

        final List<Member> members = memberRepository.finalAll();
        final ModelView mv = new ModelView("members");
        mv.getModel().put("members", members);

        return mv;
    }

}
