package com.pjh.hello.hellospring.repository;

import com.pjh.hello.hellospring.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class MemoryMemberRepositoryTest {
    MemoryMemberRepository mr = new MemoryMemberRepository();

    @AfterEach
    public void afterEach() {
        mr.clearStore();
    }

    @Test
    public void save() {
        Member m = new Member();
        m.setName("spring");

        mr.save(m);

        Member result = mr.findById(m.getId()).get();
        Assertions.assertThat(m).isEqualTo(result);
    }

    @Test
    public void findByName() {
        Member m1 = new Member();
        m1.setName("spring1");
        mr.save(m1);

        Member m2 = new Member();
        m2.setName("spring2");
        mr.save(m2);

        Member result = mr.findByName("spring1").get();
        Assertions.assertThat(result).isEqualTo(m1);
    }

    @Test
    public void findAll() {
        Member m1 = new Member();
        m1.setName("spring1");
        mr.save(m1);

        Member m2 = new Member();
        m2.setName("spring2");
        mr.save(m2);

        List<Member> result = mr.findAll();
        Assertions.assertThat(result.size()).isEqualTo(2);
    }
}
