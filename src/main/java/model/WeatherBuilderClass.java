package model;

import io.cucumber.java.eo.Se;
import lombok.*;


@Builder
public class WeatherBuilderClass {

    private String cityName;
    private String countryCode;
    WeatherDetails weatherDetails;

    public void settingWeather() {
        weatherDetails.setCityName(cityName);
        weatherDetails.setCountryCode(countryCode);
    }
}