package com.pjh.core.beanfind;

import com.pjh.core.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationContextInfoTest {
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("모든 빈 출력하기")
    void findAllBeans() {
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            Object bean = ac.getBean(beanDefinitionName);
            System.out.println("bean Name = " + beanDefinitionName + "object = " + bean);
        }
    }

    @Test
    @DisplayName("어플리케이션 등록 개발 빈 출력하기")
    void findApplicationBeans() {
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            BeanDefinition beanDefinition = ac.getBeanDefinition(beanDefinitionName);

            // ROLE_INFRASTRUCTURE : 스프링 내부 사용 빈
//            if (beanDefinition.getRole() == BeanDefinition.ROLE_INFRASTRUCTURE) {
            // ROLE_APPLICATION : 직접 등록 어플리케이션 개발 빈
            if (beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION) {
                Object bean = ac.getBean(beanDefinitionName);
                System.out.println("bean Name = " + beanDefinitionName + "object = " + bean);
            }
        }
    }
}
