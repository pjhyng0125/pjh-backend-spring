package com.pjh.servlet.web.frontcontroller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

public class MyView {
    private String viewPath;

    public MyView(String viewPath) {
        this.viewPath = viewPath;
    }

    // V2
    public void render(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher(viewPath);
        dispatcher.forward(req, res);
    }

    // V3
    public void render(Map<String, Object> model, HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException  {
        modelToRequestAttribute(model, req);
        RequestDispatcher dispatcher = req.getRequestDispatcher(viewPath);
        dispatcher.forward(req, res);
    }

    private void modelToRequestAttribute(Map<String, Object> model, HttpServletRequest req) {
        // model 에 저장된 key, value 를 request 객체에 담는 과정
        model.forEach((key, value) -> req.setAttribute(key, value));
    }
}
