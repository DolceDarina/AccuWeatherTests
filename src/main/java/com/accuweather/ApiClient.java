package com.accuweather;

import io.restassured.response.Response;
import java.util.Map;
import static io.restassured.RestAssured.given;

public class ApiClient {

    public static Response getRequest(String endpoint, Map<String, String> params) {
        return given()
                .queryParams(params)
                .when()
                .get(endpoint)
                .then()
                .extract()
                .response();
    }

    public static Response getWeather(String locationKey) {
        return getRequest("/currentconditions/v1/" + locationKey, Map.of("apikey", BaseTest.API_KEY));
    }
}
