package com.pjh.core.beanfind;

import com.pjh.core.member.MemberRepository;
import com.pjh.core.member.MemoryMemberRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

import static org.assertj.core.api.Assertions.*;

public class ApplicationContextSameBeanFindTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(SameBeanConfig.class);

    @Test
    @DisplayName("타입으로 조회 시 닽은 타입 둘 이상 있으면, 중복 오류 발생")
    void findBeanByTypeDuplication() {
        // NoUniqueBeanDefinitionException: No qualifying bean of type 'com.pjh.core.member.MemberRepository' available: expected single matching bean but found 2: memberRepository1,memberRepository2
//        MemberRepository bean = ac.getBean(MemberRepository.class);
        Assertions.assertThrows(NoUniqueBeanDefinitionException.class,
                () -> ac.getBean(MemberRepository.class));
    }

    @Test
    @DisplayName("타입으로 조회 시 닽은 타입 둘 이상 있으면, 빈 이름 지정")
    void findBeanByName() {
        MemberRepository memberReposiory = ac.getBean("memberRepository1", MemberRepository.class);
        assertThat(memberReposiory).isInstanceOf(MemberRepository.class);
    }

    @Test
    @DisplayName("특정타입 모두 조회")
    void findAllBeansByType() {
        Map<String, MemberRepository> beansOfType = ac.getBeansOfType(MemberRepository.class);
        for (String key : beansOfType.keySet()) {
            System.out.println("key = " + key);
            System.out.println("value = " + beansOfType.get(key));
        }
        System.out.println("beansOfType = " + beansOfType);
        assertThat(beansOfType.size()).isEqualTo(2);
    }

    @Configuration
    static class SameBeanConfig {
        @Bean
        public MemberRepository memberRepository1() {
            return new MemoryMemberRepository();
        }
        @Bean
        public MemberRepository memberRepository2() {
            return new MemoryMemberRepository();
        }
    }
}
