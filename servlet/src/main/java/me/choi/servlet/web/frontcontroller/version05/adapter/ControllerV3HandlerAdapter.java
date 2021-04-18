package me.choi.servlet.web.frontcontroller.version05.adapter;

import me.choi.servlet.web.frontcontroller.ModelView;
import me.choi.servlet.web.frontcontroller.MyView;
import me.choi.servlet.web.frontcontroller.version03.ControllerV3;
import me.choi.servlet.web.frontcontroller.version05.MyHandlerAdapter;

import javax.servlet.ServletException;
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
 * Time : 5:55 오후
 */
public class ControllerV3HandlerAdapter implements MyHandlerAdapter {

    @Override
    public boolean supports(final Object handler) {
        return (handler instanceof ControllerV3);
    }

    @Override
    public ModelView handle(final HttpServletRequest request, final HttpServletResponse response, final Object handler) throws ServletException, IOException {
        final ControllerV3 controller = (ControllerV3) handler;
        final Map<String, String> paramMap = createParamMap(request);

        ModelView mv = controller.process(paramMap);

        return mv;
    }

    private Map<String, String> createParamMap(final HttpServletRequest request) {
        final Map<String, String> paramMap = new HashMap<>();
        request.getParameterNames().asIterator()
                .forEachRemaining(paramName -> paramMap.put(paramName, request.getParameter(paramName)));

        return paramMap;
    }

}
