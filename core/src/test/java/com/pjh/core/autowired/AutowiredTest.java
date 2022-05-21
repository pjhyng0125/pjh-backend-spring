package com.pjh.core.autowired;

import com.pjh.core.member.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.lang.Nullable;

import java.util.Optional;

public class AutowiredTest {

    @Test
    void AutowiredOptionTest() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(TestBean.class);

    }

    static class TestBean {
        @Autowired(required = false)
        public void setNoBean1(Member boBean1) {
            // 의존관계 없으면 메소드 자체 호출 안 됨.
            System.out.println("boBean1 = " + boBean1);
        }
        @Autowired
        public void setBoBean2(@Nullable Member boBean2) {
            // null일 경우에도 메소드 호출 가능
            System.out.println("boBean2 = " + boBean2);
        }
        @Autowired
        public void setBoBean3(Optional<Member> boBean3) {
            // java 8 제공 문법, 값이 없으면 Optional.empty
            System.out.println("boBean3 = " + boBean3);
        }
    }
}
