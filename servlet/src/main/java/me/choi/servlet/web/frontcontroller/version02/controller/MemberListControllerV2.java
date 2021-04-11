package me.choi.servlet.web.frontcontroller.version02.controller;

import me.choi.servlet.domain.member.Member;
import me.choi.servlet.domain.member.MemberRepository;
import me.choi.servlet.web.frontcontroller.MyView;
import me.choi.servlet.web.frontcontroller.version02.ControllerV2;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Project : servlet
 *
 * @author : jwdeveloper
 * @comment :
 * Time : 10:07 오후
 */
public class MemberListControllerV2 implements ControllerV2 {

    private MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    public MyView process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Member> members = memberRepository.finalAll();
        request.setAttribute("members", members);

        return new MyView("/WEB-INF/views/members.jsp");
    }
}
