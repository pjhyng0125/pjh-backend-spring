package com.pjh.hello.hellospring.sample;

import com.pjh.hello.hellospring.domain.Member;
import com.pjh.hello.hellospring.repository.MemberRepository;
import com.pjh.hello.hellospring.repository.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class MapStreamRamdaTest {
    MemberRepository mr = new MemoryMemberRepository();

    Map<String, String> saladStore = new HashMap<>();

    @BeforeEach
    public void initMap() {
        saladStore.put("1", "파스타샐러드");
        saladStore.put("2", "삼겹살샐러드");
        saladStore.put("3", "두부샐러드");
    }

    @Test
    public void filterMapKey() {
        String findStr = "1";
        Optional<String> findItem = saladStore.keySet().stream()
                .filter(item -> item.equals(findStr))
                .findAny();

        Assertions.assertThat(findItem.get()).isEqualTo(findStr);
    }

    @Test
    public void filterMapValue() {
        String findStr = "두부샐러드";
        Optional<String> findSalad = saladStore.values().stream()
                .filter(salad -> salad.equals(findStr))
                .findAny();

        Assertions.assertThat(findSalad.get()).isEqualTo(findStr);
    }

    @Test
    public void filterMapInstanceValue() {
        Map<Long, Salad> saladStore = new HashMap<>();
        saladStore.put(1L, new Salad("파스타샐러드", 6000));
        saladStore.put(2L, new Salad("삼겹살샐러드", 4000));
        saladStore.put(3L, new Salad("두부샐러드", 5000));

        String findStr = "두부샐러드";
        Optional<Salad> findSalad = saladStore.values().stream()
                .filter(salad -> salad.getName().equals(findStr))
                .findAny();

        Assertions.assertThat(findSalad.get().getName()).isEqualTo(findStr);
    }
    static class Salad {
        private String name;
        private int price;

        public Salad(String name, int price) {
            this.name = name;
            this.price = price;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getPrice() {
            return price;
        }

        public void setPrice(int price) {
            this.price = price;
        }
    }
}
