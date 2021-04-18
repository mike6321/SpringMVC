package me.choi.servlet.web.frontcontroller.version05;

import me.choi.servlet.web.frontcontroller.ModelView;
import me.choi.servlet.web.frontcontroller.MyView;
import me.choi.servlet.web.frontcontroller.version03.ControllerV3;
import me.choi.servlet.web.frontcontroller.version03.controller.MemberFormControllerV3;
import me.choi.servlet.web.frontcontroller.version03.controller.MemberListControllerV3;
import me.choi.servlet.web.frontcontroller.version03.controller.MemberSaveControllerV3;
import me.choi.servlet.web.frontcontroller.version04.ControllerV4;
import me.choi.servlet.web.frontcontroller.version05.adapter.ControllerV3HandlerAdapter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

/**
 * Project : servlet
 *
 * @author : jwdeveloper
 * @comment :
 * Time : 6:04 오후
 */
@WebServlet(name = "frontControllerServletV5", urlPatterns = "/front-controller/v5/*")
public class FrontControllerServletV5 extends HttpServlet {

    private final Map<String, Object> hadlerMappingMap = new HashMap<>();
    private final List<MyHandlerAdapter> handlerAdapters = new ArrayList<>();

    public FrontControllerServletV5() {
        initHandlerMappingMap();
        initHandlerAdapters();
    }

    private void initHandlerAdapters() {
        handlerAdapters.add(new ControllerV3HandlerAdapter());
    }

    private void initHandlerMappingMap() {
        this.hadlerMappingMap.put("/front-controller/v5/v3/members/new-form", new MemberFormControllerV3());
        this.hadlerMappingMap.put("/front-controller/v5/v3/members/save", new MemberSaveControllerV3());
        this.hadlerMappingMap.put("/front-controller/v5/v3/members", new MemberListControllerV3());
    }

    @Override
    protected void service(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
        final Object handler = getHandler(request);

        if (handler == null) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
        }

        MyHandlerAdapter adapter = getHadnlerAdapter(handler);
        ModelView mv = adapter.handle(request, response, handler);

        String viewName = mv.getViewName();
        MyView view = viewResolver(viewName);

        view.render(mv.getModel(), request, response);
    }

    private MyHandlerAdapter getHadnlerAdapter(final Object handler) {

        for (MyHandlerAdapter adapter : handlerAdapters) {
            if (adapter.supports(handler)) {
                return adapter;
            }
        }

        throw new IllegalArgumentException("handler adapter를 찾을 수 없습니다...!" + handler);
    }

    private Object getHandler(final HttpServletRequest request) {
        final String requestURI = request.getRequestURI();
        final ControllerV3 controller = (ControllerV3) hadlerMappingMap.get(requestURI);
        return controller;
    }

    private MyView viewResolver(final String viewName) {
        return new MyView("/WEB-INF/views/" + viewName + ".jsp");
    }
}
