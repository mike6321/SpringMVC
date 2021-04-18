package me.choi.servlet.web.frontcontroller.version05.adapter;

import me.choi.servlet.web.frontcontroller.ModelView;
import me.choi.servlet.web.frontcontroller.version04.ControllerV4;
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
 * Time : 6:44 오후
 */
public class ControllerV4HandlerAdapter implements MyHandlerAdapter {

    @Override
    public boolean supports(final Object handler) {
        return (handler instanceof ControllerV4);
    }

    @Override
    public ModelView handle(final HttpServletRequest request, final HttpServletResponse response, final Object handler) throws ServletException, IOException {
        final ControllerV4 controller = (ControllerV4) handler;
        final Map<String, String> paramMap = createParamMap(request);
        final Map<String, Object> model = new HashMap<>();

        final String viewName = controller.process(paramMap, model);

        final ModelView mv = new ModelView(viewName);
        mv.setModel(model);

        return mv;
    }

    private Map<String, String> createParamMap(final HttpServletRequest request) {
        final Map<String, String> paramMap = new HashMap<>();
        request.getParameterNames().asIterator()
                .forEachRemaining(paramName -> paramMap.put(paramName, request.getParameter(paramName)));

        return paramMap;
    }
}
