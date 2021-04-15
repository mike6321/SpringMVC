package me.choi.servlet.web.frontcontroller.version01;

import me.choi.servlet.web.frontcontroller.version01.controller.MemberFormControllerV1;
import me.choi.servlet.web.frontcontroller.version01.controller.MemberListController;
import me.choi.servlet.web.frontcontroller.version01.controller.MemberSaveControllerV1;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Project : servlet
 *
 * @author : jwdeveloper
 * @comment : 현재의 문제점 :
 * Controller의 책임이 너무 무겁다.
 * HttpServletRequest, HttpServletResponse등의 사용하지 않는 코드가 너무 많다.
 * Time : 9:13 오후
 */
@WebServlet(name = "frontControllerServletV1", urlPatterns = "/front-controller/v1/*")
public class FrontControllerServletV1 extends HttpServlet {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    private Map<String, ControllerV1> controllerMap = new HashMap<>();

    public FrontControllerServletV1() {
        this.controllerMap.put("/front-controller/v1/members/new-form", new MemberFormControllerV1());
        this.controllerMap.put("/front-controller/v1/members/save", new MemberSaveControllerV1());
        this.controllerMap.put("/front-controller/v1/members", new MemberListController());
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        logger.info("FrontControllerServletV1.service");

        String requestURI = request.getRequestURI();
        ControllerV1 controller = controllerMap.get(requestURI);
        if (controller == null) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        controller.process(request, response);
    }
}
