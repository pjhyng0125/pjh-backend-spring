package com.pjh.core.singleton;

public class SingletonService {

    // 자기 자신의 인스턴스 생성
    private static final SingletonService instance = new SingletonService();

    public static SingletonService getInstance() {
        return instance;
    }

    private SingletonService() {}

    public void logic() {
        System.out.println("call Singleton instance logic");
    }
}
