package me.choi.servlet.web.frontcontroller.version04.controller;

import me.choi.servlet.domain.member.Member;
import me.choi.servlet.domain.member.MemberRepository;
import me.choi.servlet.web.frontcontroller.ModelView;
import me.choi.servlet.web.frontcontroller.version03.ControllerV3;
import me.choi.servlet.web.frontcontroller.version04.ControllerV4;

import java.util.List;
import java.util.Map;

/**
 * Project : servlet
 *
 * @author : jwdeveloper
 * @comment :
 * Time : 9:37 오후
 */
public class MemberListControllerV4 implements ControllerV4 {

    private final MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    public String process(final Map<String, String> paramMap, final Map<String, Object> model) {
        final List<Member> members = memberRepository.finalAll();
        final ModelView mv = new ModelView("members");
        model.put("members", members);

        return "members";
    }
}
