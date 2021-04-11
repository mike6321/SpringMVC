package me.choi.servlet.web.frontcontroller.version02;

import me.choi.servlet.web.frontcontroller.MyView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Project : servlet
 *
 * @author : jwdeveloper
 * @comment :
 * Time : 10:00 오후
 */
public interface ControllerV2 {

    MyView process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
}
