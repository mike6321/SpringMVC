package me.choi.servlet.web.frontcontroller.version04;

import me.choi.servlet.web.frontcontroller.ModelView;
import me.choi.servlet.web.frontcontroller.MyView;
import me.choi.servlet.web.frontcontroller.version03.ControllerV3;
import me.choi.servlet.web.frontcontroller.version03.controller.MemberFormControllerV3;
import me.choi.servlet.web.frontcontroller.version03.controller.MemberListControllerV3;
import me.choi.servlet.web.frontcontroller.version03.controller.MemberSaveControllerV3;
import me.choi.servlet.web.frontcontroller.version04.controller.MemberFormControllerV4;
import me.choi.servlet.web.frontcontroller.version04.controller.MemberListControllerV4;
import me.choi.servlet.web.frontcontroller.version04.controller.MemberSaveControllerV4;
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
 * @comment :
 * Time : 9:13 오후
 */
@WebServlet(name = "frontControllerServletV4", urlPatterns = "/front-controller/v4/*")
public class FrontControllerServletV4 extends HttpServlet {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private final Map<String, ControllerV4> controllerMap = new HashMap<>();

    public FrontControllerServletV4() {
        this.controllerMap.put("/front-controller/v4/members/new-form", new MemberFormControllerV4());
        this.controllerMap.put("/front-controller/v4/members/save", new MemberSaveControllerV4());
        this.controllerMap.put("/front-controller/v4/members", new MemberListControllerV4());
    }

    @Override
    protected void service(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {

        final String requestURI = request.getRequestURI();
        final ControllerV4 controller = controllerMap.get(requestURI);

        if (controller == null) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        final Map<String, String> paramMap = createParamMap(request);
        final Map<String, Object> model = new HashMap<>();
        final String viewName = controller.process(paramMap, model);

        final MyView view = viewResolver(viewName);

        view.render(model, request, response);
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
