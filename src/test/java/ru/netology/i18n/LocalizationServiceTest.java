package ru.netology.i18n;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import ru.netology.entity.Country;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LocalizationServiceTest {
    private static long suiteStartTime;
    private long testStartTime;

    @BeforeAll
    public static void initSuite() {
        System.out.println("Running locale_test");
        suiteStartTime = System.nanoTime();
    }

    @AfterAll
    public static void completeSuite() {
        System.out.println("locale_test complete: " + (System.nanoTime() - suiteStartTime));
    }

    @BeforeEach
    public void initTest() {
        System.out.println("Starting new locale_test");
        testStartTime = System.nanoTime();
    }

    @AfterEach
    public void finalizeTest() {
        System.out.println("Test complete:" + (System.nanoTime() - testStartTime));
    }

    @ParameterizedTest
    @EnumSource(Country.class)
    void locale_test(Country arg) {
       final LocalizationService localizationService = new LocalizationServiceImpl();
        String expected;
        if (arg == Country.RUSSIA) {
            expected = "Добро пожаловать";
        } else {
            expected = "Welcome";
        }

        assertEquals(expected, localizationService.locale(arg));
    }

}