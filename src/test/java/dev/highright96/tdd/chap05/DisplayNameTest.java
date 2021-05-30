package dev.highright96.tdd.chap05;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("@DisplayName 테스트")
public class DisplayNameTest {

    @DisplayName("테스트 A")
    @Test
    void a() {
        System.out.println("DisplayNameTest.a");
    }

    @DisplayName("테스트 B")
    @Test
    void b() {
        System.out.println("DisplayNameTest.b");
    }

}
