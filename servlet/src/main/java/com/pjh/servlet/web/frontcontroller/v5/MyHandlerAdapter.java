package com.pjh.servlet.web.frontcontroller.v5;

import com.pjh.servlet.web.frontcontroller.ModelView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.rowset.serial.SerialException;
import java.io.IOException;

public interface MyHandlerAdapter {

    boolean supports(Object handler);

    ModelView handle(HttpServletRequest req, HttpServletResponse res, Object handler) throws SerialException, IOException;
}
