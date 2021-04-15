package me.choi.servlet.web.frontcontroller.version01.controller;

import me.choi.servlet.domain.member.Member;
import me.choi.servlet.domain.member.MemberRepository;
import me.choi.servlet.web.frontcontroller.version01.ControllerV1;

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
 * Time : 9:12 오후
 */
public class MemberListController implements ControllerV1 {

    private final MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    public void process(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {

        final List<Member> members = memberRepository.finalAll();
        request.setAttribute("members", members);

        final String viewPath = "/WEB-INF/views/members.jsp";
        final RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);
        dispatcher.forward(request, response);
    }
}
