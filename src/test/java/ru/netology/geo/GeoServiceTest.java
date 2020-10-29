package ru.netology.geo;

import org.junit.jupiter.api.*;
import ru.netology.entity.Location;

class GeoServiceTest {
    private static long suiteStartTime;
    private long testStartTime;

    @BeforeAll
    public static void initSuite() {
        System.out.println("Running test_byIp");
        suiteStartTime = System.nanoTime();
    }

    @AfterAll
    public static void completeSuite() {
        System.out.println("test_byIp complete: " + (System.nanoTime() - suiteStartTime));
    }

    @BeforeEach
    public void initTest() {
        System.out.println("Starting new test_byIp");
        testStartTime = System.nanoTime();
    }

    @AfterEach
    public void finalizeTest() {
        System.out.println("Test complete:" + (System.nanoTime() - testStartTime));
    }

    @Test
    void test_byIp() {
        final GeoService geoService = new GeoServiceImpl();

        final String LOCALHOST = "127.0.0.1";
        final String MOSCOW_IP = "172.0.32.11";
        final String NEW_YORK_IP = "96.44.183.149";

        String expected = "Moscow";

        Location actual = geoService.byIp("96.44.183.149");

        Assertions.assertEquals(expected, actual.getCity());
    }

}