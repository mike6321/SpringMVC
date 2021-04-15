package me.choi.servlet.web.frontcontroller.version01;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Project : servlet
 *
 * @author : jwdeveloper
 * @comment :
 * Time : 9:00 오후
 */
public interface ControllerV1 {

    void process(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException;

}
