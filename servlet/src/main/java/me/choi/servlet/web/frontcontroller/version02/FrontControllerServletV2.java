package me.choi.servlet.web.frontcontroller.version02;

import me.choi.servlet.web.frontcontroller.MyView;
import me.choi.servlet.web.frontcontroller.version01.ControllerV1;
import me.choi.servlet.web.frontcontroller.version01.controller.MemberFormControllerV1;
import me.choi.servlet.web.frontcontroller.version01.controller.MemberListController;
import me.choi.servlet.web.frontcontroller.version01.controller.MemberSaveControllerV1;
import me.choi.servlet.web.frontcontroller.version02.controller.MemberFormControllerV2;
import me.choi.servlet.web.frontcontroller.version02.controller.MemberListControllerV2;
import me.choi.servlet.web.frontcontroller.version02.controller.MemberSaveControllerV2;
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
@WebServlet(name = "frontControllerServletV2", urlPatterns = "/front-controller/v2/*")
public class FrontControllerServletV2 extends HttpServlet {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    private Map<String, ControllerV2> controllerMap = new HashMap<>();

    public FrontControllerServletV2() {
        this.controllerMap.put("/front-controller/v2/members/new-form", new MemberFormControllerV2());
        this.controllerMap.put("/front-controller/v2/members/save", new MemberSaveControllerV2());
        this.controllerMap.put("/front-controller/v2/members", new MemberListControllerV2());
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String requestURI = request.getRequestURI();
        ControllerV2 controller = controllerMap.get(requestURI);

        if (controller == null) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }
        
        // TODO: MyView로 랜더링 하는 과정 추가 (Controller의 부담을 덜어 주었다.) 2021/04/15 8:26 오후
        MyView view = controller.process(request, response);
        view.render(request, response);
    }
}
