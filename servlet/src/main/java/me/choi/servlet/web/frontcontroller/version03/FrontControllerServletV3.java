package me.choi.servlet.web.frontcontroller.version03;

import me.choi.servlet.web.frontcontroller.ModelView;
import me.choi.servlet.web.frontcontroller.MyView;
import me.choi.servlet.web.frontcontroller.version03.controller.MemberFormControllerV3;
import me.choi.servlet.web.frontcontroller.version03.controller.MemberListControllerV3;
import me.choi.servlet.web.frontcontroller.version03.controller.MemberSaveControllerV3;
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
 * @comment : 현재의 문제점 : HttpServletRequest, HttpServletResponse등의 사용하지 않는 코드가 너무 많다.
 * Time : 9:13 오후
 */
@WebServlet(name = "frontControllerServletV3", urlPatterns = "/front-controller/v3/*")
public class FrontControllerServletV3 extends HttpServlet {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private final Map<String, ControllerV3> controllerMap = new HashMap<>();

    public FrontControllerServletV3() {
        this.controllerMap.put("/front-controller/v3/members/new-form", new MemberFormControllerV3());
        this.controllerMap.put("/front-controller/v3/members/save", new MemberSaveControllerV3());
        this.controllerMap.put("/front-controller/v3/members", new MemberListControllerV3());
    }

    @Override
    protected void service(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {

        final String requestURI = request.getRequestURI();
        final ControllerV3 controller = controllerMap.get(requestURI);

        if (controller == null) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        final Map<String, String> paramMap = createParamMap(request);
        final ModelView mv = controller.process(paramMap);

        final String viewName = mv.getViewName();// 논리이름
        final MyView view = viewResolver(viewName);
        view.render(mv.getModel(), request, response);
    }

    private MyView viewResolver(final String viewName) {
        return new MyView("/WEB-INF/views/" + viewName + ".jsp");
    }

    private Map<String, String> createParamMap(final HttpServletRequest request) {
        final Map<String, String> paramMap = new HashMap<>();
        request.getParameterNames().asIterator()
                .forEachRemaining(paramName -> paramMap.put(paramName, request.getParameter(paramName)));
        return paramMap;
    }
}
