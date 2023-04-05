package weatherCrudOperation;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import model.RestResponse;
import utils.Constant;


public class GetRequest {

    public GetRequest() {
        RestAssured.baseURI = Constant.baseUrl;
    }
    public static Response getWithHeaderQueryParamsOfCityNames(String cityName, String url) {
        return RestAssured.given()
                .contentType("application/json")
                .headers("X-RapidAPI-Key", Constant.rapidAuthKey)
                .headers("X-RapidAPI-Host", Constant.rapidHostKey)
                .queryParam("city", cityName)
                .when()
                .get(url);
    }
    public static Response getWithHeaderQueryParamsOfLongitudeAndLatitude(String longitude,String latitude, String url) {
        return RestAssured.given()
                .contentType("application/json")
                .headers("X-RapidAPI-Key", Constant.rapidAuthKey)
                .headers("X-RapidAPI-Host", Constant.rapidHostKey)
                .queryParam("latitude", latitude)
                .queryParam("longitude",longitude)
                .when()
                .get(url);
    }
    public static Response getWithHeaderQueryParamsWithoutBearerToken(String cityName,String url) {
        return RestAssured.given()
                .contentType("application/json")
                .headers("X-RapidAPI-Key", "")
                .headers("X-RapidAPI-Host", Constant.rapidHostKey)
                .queryParam("city", cityName)
                .when()
                .get(url);
    }
}
