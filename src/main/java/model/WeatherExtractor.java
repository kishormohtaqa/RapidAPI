package model;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class WeatherExtractor {
    JsonPath listMap;
    public void extractWeatherDetails(Response response) {
        listMap = response.getBody().jsonPath();

        WeatherBuilderClass.builder()
                .cityName((String) listMap.get("data[0].city_name"))
                .countryCode((String) listMap.get("data[0].country_code"))
                .build();

    }
}
