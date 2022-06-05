package com.pjh.servlet.basic.response;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pjh.servlet.basic.HelloData;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name="responseJsonServlet", urlPatterns = "/response-json")
public class ResponseJsonServlet extends HttpServlet {

    private ObjectMapper om = new ObjectMapper();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        //Content-type: application/json
        res.setContentType("application/json");
        res.setCharacterEncoding("UTF-8");

        HelloData helloData = new HelloData();
        helloData.setUsername("park");
        helloData.setAge(30);

        // {"username":"park, "age":30}
        String jsonStr = om.writeValueAsString(helloData);
        res.getWriter().write(jsonStr);
    }
}
