package com.pjh.core.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.junit.jupiter.api.Assertions.*;

class StatefulServiceTest {

    @Test
    @DisplayName("싱글톤 패턴 방식 주의할 점")
    void statefulServiceSingletonTest() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StatefulService statefulService1 = ac.getBean(StatefulService.class);
        StatefulService statefulService2 = ac.getBean(StatefulService.class);

        int user1Price = statefulService1.order("A", 10000);
        System.out.println("user1Price = " + user1Price);

        int user2Price = statefulService2.order("B", 20000);
        System.out.println("user2Price = " + user2Price);

//        int price = statefulService1.getPrice();
//        System.out.println("price = " + price);
//        Assertions.assertThat(statefulService1.getPrice()).isEqualTo(20000);
        Assertions.assertThat(user1Price).isNotEqualTo(20000);
    }

    static class TestConfig {

        @Bean
        public StatefulService statefulService() {
            return new StatefulService();
        }
    }
}