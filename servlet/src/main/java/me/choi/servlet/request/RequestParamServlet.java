package me.choi.servlet.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.stream.Stream;

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

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO: Http 요청 데이터 - GET 쿼리 파라미터 - 전체 파라미터 조회 2021/03/16 1:12 오후
        System.out.println("[전체 파라미터 조회] - start");
        request.getParameterNames().asIterator()
                                   .forEachRemaining(paramName -> System.out.println(paramName + " = " + request.getParameter(paramName)));
        System.out.println("[전체 파라미터 조회] - end");

        // TODO: Http 요청 데이터 - GET 쿼리 파라미터 - 단일 파라미터 조회 2021/03/16 1:12 오후
        System.out.println("[단일 파라미터 조회] - start");
        String username = request.getParameter("username");
        String age = request.getParameter("age");

        System.out.println("age = " + age);
        System.out.println("username = " + username);
        System.out.println("[단일 파라미터 조회] - end");

        // TODO: Http 요청 데이터 - GET 쿼리 파라미터 - 이름이 같은 복수 파라미터 조회 2021/03/16 1:12 오후
        /**
         * http://localhost:8080/request-param?username=hello&age=20&username=hello2
         * */
        System.out.println("[이름이 같은 복수 파라미터 조회] - start");
        String[] usernames = request.getParameterValues("username");
        Arrays.stream(usernames)
              .forEach(user -> System.out.println("username = " + user));
        System.out.println("[이름이 같은 복수 파라미터 조회] - end");

        response.getWriter().write("ok");

    }
}
