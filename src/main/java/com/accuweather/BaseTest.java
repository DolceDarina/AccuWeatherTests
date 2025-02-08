package com.accuweather;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;

public class BaseTest {
    protected static final String BASE_URL = "https://dataservice.accuweather.com";
    protected static final String API_KEY = "h90bHTYjkehJNsyoao9XQXe9I9YNDu41";

    @BeforeAll
    static void setup() {
        RestAssured.baseURI = BASE_URL;
    }
}
