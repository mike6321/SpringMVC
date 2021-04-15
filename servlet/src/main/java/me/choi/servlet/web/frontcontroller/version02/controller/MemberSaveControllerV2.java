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

/**
 * Project : servlet
 *
 * @author : jwdeveloper
 * @comment :
 * Time : 10:06 오후
 */
public class MemberSaveControllerV2 implements ControllerV2 {

    private final MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    public MyView process(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
        final String username = request.getParameter("username");
        final int age = Integer.parseInt(request.getParameter("age"));

        final Member member = new Member(username, age);
        memberRepository.save(member);

        //Model에 데이터를 보관한다.
        request.setAttribute("member", member);

        return new MyView("/WEB-INF/views/save-result.jsp");
    }
}
