package me.choi.servlet.request;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

/**
 * Project : servlet
 *
 * @author : jwdeveloper
 * @comment :
 * http://localhost:8080/request-param?username=hello&age=20
 * Time : 1:09 오후
 */
@WebServlet(name = "requestParamServlet", urlPatterns = "/request-param")
public class RequestParamServlet extends HttpServlet {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO: Http 요청 데이터 - GET 쿼리 파라미터 - 전체 파라미터 조회 2021/03/16 1:12 오후
        logger.info("[전체 파라미터 조회] - start");
        request.getParameterNames().asIterator()
                                   .forEachRemaining(paramName -> System.out.println(paramName + " = " + request.getParameter(paramName)));
        logger.info("[전체 파라미터 조회] - end");

        // TODO: Http 요청 데이터 - GET 쿼리 파라미터 - 단일 파라미터 조회 2021/03/16 1:12 오후
        logger.info("[단일 파라미터 조회] - start");
        String username = request.getParameter("username");
        String age = request.getParameter("age");

        logger.info("age = " + age);
        logger.info("username = " + username);
        logger.info("[단일 파라미터 조회] - end");


        // TODO: Http 요청 데이터 - GET 쿼리 파라미터 - 이름이 같은 복수 파라미터 조회 2021/03/16 1:12 오후
        /**
         * http://localhost:8080/request-param?username=hello&age=20&username=hello2
         * */

        logger.info("[이름이 같은 복수 파라미터 조회] - start");
        String[] usernames = request.getParameterValues("username");
        Arrays.stream(usernames)
              .forEach(user -> System.out.println("username = " + user));
        logger.info("[이름이 같은 복수 파라미터 조회] - end");
        response.getWriter().write("ok");

    }
}
