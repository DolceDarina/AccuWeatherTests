package com.accuweather;

import static org.hamcrest.Matchers.hasSize;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static io.restassured.RestAssured.given;
import io.restassured.response.Response;

class ForecastTest extends BaseTest {

    @ParameterizedTest
    @CsvSource({
            "28580, Минск",
            "28580_PC, Гродно",
            "28580_BS, Брест"
    })
    void testGet5DayForecast(String locationKey, String cityName) {
        Response response = given()
                .queryParam("apikey", API_KEY)
                .when()
                .get("/forecasts/v1/daily/5day/" + locationKey)
                .then()
                .statusCode(200)
                .body("DailyForecasts", hasSize(5))
                .extract().response();

        System.out.println("Ответ API для города " + cityName + ": " + response.asString());
    }
}
