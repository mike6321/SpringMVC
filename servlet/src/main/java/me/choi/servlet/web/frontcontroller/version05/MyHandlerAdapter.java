package me.choi.servlet.web.frontcontroller.version05;

import me.choi.servlet.web.frontcontroller.ModelView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Project : servlet
 *
 * @author : jwdeveloper
 * @comment :
 * Time : 5:54 오후
 */
public interface MyHandlerAdapter {

    boolean supports(final Object handler);

    ModelView handle(final HttpServletRequest request, final HttpServletResponse response, final Object handler) throws ServletException, IOException;

}
