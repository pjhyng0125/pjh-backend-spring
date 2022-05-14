package com.pjh.core.scan;

import com.pjh.core.AutoAppConfig;
import com.pjh.core.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AutoAppConfigTest {

    @Test
    @DisplayName("컴포넌트 스캔 자동 주입")
    void basicScan() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class);

        MemberService bean = ac.getBean(MemberService.class);
        System.out.println("bean = " + bean);
        Assertions.assertThat(bean).isInstanceOf(MemberService.class);
    }
}
