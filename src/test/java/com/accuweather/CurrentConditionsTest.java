package com.accuweather;

import io.restassured.response.Response;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

class CurrentConditionsTest extends BaseTest {

    @ParameterizedTest
    @CsvSource({
            "28580, Минск",
            "28580_PC, Гродно",
            "28580_BS, Брест"
    })
    void testGetCurrentConditions(String locationKey, String cityName) {
        Response response = given()
                .queryParam("apikey", API_KEY)
                .when()
                .get("/currentconditions/v1/" + locationKey)
                .then()
                .statusCode(200)
                .body("$", hasSize(greaterThan(0)))
                .extract().response();

        System.out.println("✅ Текущая погода для города " + cityName + ": " + response.asString());
    }
}
