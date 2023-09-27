package com.example.service;

import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class BasicTest {
    @BeforeAll
    public static void beforeAll() {
        System.out.println("매 테스트시 호출");
    }
    
    @BeforeEach
    public void beforeEach() {
        System.out.println("테스트 전 한번 호출");
    }
    
    @AfterAll
    public static void afterAll() {
        System.out.println("매 테스트 후 호출");
    }
    
    @AfterEach
    public void afterEach() {
        System.out.println("테스트 후 한번 호출");
    }
    
    @Test
    @DisplayName("더하기 테스트")
    public void calTest() {
        //given
        int a = 4;
        int b = 3;

        //when
        int expectedResult = 7;
        int sum = a+b;

        assertEquals(expectedResult,sum);
        System.out.println("테스트 완료");

    }
}
