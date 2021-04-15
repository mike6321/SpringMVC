package me.choi.servlet.web.frontcontroller.version02.controller;

import me.choi.servlet.web.frontcontroller.MyView;
import me.choi.servlet.web.frontcontroller.version02.ControllerV2;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Project : servlet
 *
 * @author : jwdeveloper
 * @comment :
 * Time : 10:04 오후
 */
public class MemberFormControllerV2 implements ControllerV2 {
    @Override
    public MyView process(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
        return new MyView("/WEB-INF/views/new-form.jsp");
    }
}
