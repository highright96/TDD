package dev.highright96.tdd.chap05;

import org.junit.jupiter.api.*;

public class LifeCycleTest {

    @BeforeAll
    static void beforeAll(){
        System.out.println("Junit5Test.beforeAll");
    }

    @BeforeEach
    void beforeEach() {
        System.out.println("Junit5Test.beforeEach");
    }

    @Test
    void a() {
        System.out.println("A");
    }

    @Test
    void b() {
        System.out.println("B");
    }

    @AfterEach
    void afterEach() {
        System.out.println("Junit5Test.afterEach");
    }

    @AfterAll
    static void afterAll(){
        System.out.println("Junit5Test.afterAll");
    }
}
