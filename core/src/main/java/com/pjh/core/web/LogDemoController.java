package com.pjh.core.web;

import com.pjh.core.common.MyLogger;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequiredArgsConstructor
public class LogDemoController {

    private final LogDemoService logDemoService;
//    private final ObjectProvider<MyLogger> myLoggerProvider;
    private final MyLogger myLogger;

    @RequestMapping("log-demo")
    @ResponseBody // 문자 그대로 응답 가능
    public String legDemo(HttpServletRequest req) {
        String reqestURL = req.getRequestURL().toString();

        System.out.println("LogDemoController.legDemo : " + myLogger.getClass());
        // LogDemoController.legDemo : class com.pjh.core.common.MyLogger$$EnhancerBySpringCGLIB$$d0b9c4dc

//        MyLogger myLogger = myLoggerProvider.getObject();
        myLogger.setRequestURL(reqestURL);

        myLogger.log("controller test!");
        logDemoService.logic("testId");
        return "OK";
    }
}
