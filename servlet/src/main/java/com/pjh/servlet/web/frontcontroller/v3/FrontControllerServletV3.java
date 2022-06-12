package com.pjh.servlet.web.frontcontroller.v3;

import com.pjh.servlet.web.frontcontroller.ModelView;
import com.pjh.servlet.web.frontcontroller.MyView;
import com.pjh.servlet.web.frontcontroller.v2.ControllerV2;
import com.pjh.servlet.web.frontcontroller.v3.controller.MemberFormControllerV3;
import com.pjh.servlet.web.frontcontroller.v3.controller.MemberListControllerV3;
import com.pjh.servlet.web.frontcontroller.v3.controller.MemberSaveControllerV3;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "frontControllerServeltV3", urlPatterns = "/front-controller/v3/*")
public class FrontControllerServletV3 extends HttpServlet {

    private Map<String, ControllerV3> controllerV3Map = new HashMap<>();

    public FrontControllerServletV3() {
        controllerV3Map.put("/front-controller/v3/members/new-form", new MemberFormControllerV3());
        controllerV3Map.put("/front-controller/v3/members/save", new MemberSaveControllerV3());
        controllerV3Map.put("/front-controller/v3/members", new MemberListControllerV3());
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        System.out.println("FrontControllerServletV3.service");

        String requestURI = req.getRequestURI();

        ControllerV3 controller = controllerV3Map.get(requestURI);
        if (controller == null) {
            res.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        Map<String, String> paramMap = createParamMap(req);

        ModelView mv = controller.process(paramMap);

        String viewName = mv.getViewName(); // 논리 이름 new-form

        MyView view = viewResolver(viewName);

        view.render(mv.getModel(), req, res);
    }

    private MyView viewResolver(String viewName) {
        return new MyView("/WEB-INF/views/" + viewName + ".jsp");
    }

    private Map<String, String> createParamMap(HttpServletRequest req) {
        // request param 모두 get, paramMap 생성
        Map<String, String> paramMap = new HashMap<>();
        req.getParameterNames().asIterator()
                .forEachRemaining(paramName -> paramMap.put(paramName, req.getParameter(paramName)));
        return paramMap;
    }
}
