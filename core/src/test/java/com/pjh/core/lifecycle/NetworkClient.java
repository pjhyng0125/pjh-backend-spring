package com.pjh.core.lifecycle;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

//public class NetworkClient implements InitializingBean, DisposableBean {
public class NetworkClient {

    private String url;

    public NetworkClient() {
        System.out.println("생성자 호출 ! url : " + url);
    }

    public void setUrl(String url) {
        this.url = url;
    }

    // 서비스 시작시 호출
    public void connect() {
        System.out.println("connect : " + url);
    }
    
    public void call(String msg) {
        System.out.println("call : " + url + " msg : " + msg);
    }
    
    // 서비스 종료시 호출
    public void disconnect() {
        System.out.println("close ! " + url);
    }

    // 스프링 의존관계 주입 종료 후 호출
//    @Override
//    public void afterPropertiesSet() throws Exception {
    @PostConstruct
    public void init() {
        System.out.println("NetworkClient.afterPropertiesSet");
        connect();
        call("초기화 연결 메세지");        
    }

    // 스프링 빈 종료 시 호출
//    @Override
//    public void destroy() throws Exception {
    @PreDestroy
    public void close() {
        System.out.println("NetworkClient.destroy");
        disconnect();
    }
}
