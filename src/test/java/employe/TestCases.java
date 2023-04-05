package employe;

import io.restassured.response.Response;
import model.*;
import org.testng.Reporter;
import org.testng.annotations.Test;
import utils.Constant;
import weatherCrudOperation.GetRequest;

public class TestCases extends WeatherDetails{
	RestResponse restResponse=new RestResponse();
	GetRequest getRequest=new GetRequest();

	@Test(description = "Retrieve the current weather conditions for a valid location.")
	public void testGetWeatherDataForValidLocation(){

		Response response= GetRequest.getWithHeaderQueryParamsOfCityNames("Singapore", Constant.getCurrentWeatherDetails);

		restResponse.setResponseBody(response.getBody().asString());
		restResponse.setResponseCode(response.getStatusCode());
		restResponse.setListMap(response.getBody().jsonPath());

		System.out.println(response.getBody().asString());

		new WeatherExtractor().extractWeatherDetails(response);
		new RestValidator(restResponse).validateStatusCode(Constant.okayCode).validateCountryCode(Constant.countryCode).validateCityName(Constant.cityName);
	}

	@Test(description = "Retrieve the weather data for an invalid location.")
	public void testGetWeatherDataForInvalidLocation() {
		Response response= GetRequest.getWithHeaderQueryParamsOfCityNames("xyzdfe", Constant.getCurrentWeatherDetails);

		restResponse.setResponseBody(response.getBody().asString());
		restResponse.setResponseCode(response.getStatusCode());

		System.out.println(response.getBody().asString());
		new RestValidator(restResponse).validateStatusCode(Constant.noContentFound);
	}

	@Test(description = "Retrieve the weather data for an invalid Auth Token")
	public void testGetWeatherDataForInvalidAuthToken() {
		Response response= GetRequest.getWithHeaderQueryParamsWithoutBearerToken("Singapore", Constant.getCurrentWeatherDetails);

		restResponse.setResponseBody(response.getBody().asString());
		restResponse.setResponseCode(response.getStatusCode());

		System.out.println(response.getBody().asString());
		new RestValidator(restResponse).validateStatusCode(Constant.notAuthorised);
	}

	@Test(description = "Retrieve the weather data for an valid location.")
	public void testGetWeatherDataForValidLatitudeAndLongitude(){
		Response response= GetRequest.getWithHeaderQueryParamsOfLongitudeAndLatitude("103.8501","1.28967", Constant.getCurrentWeatherDetails);

		restResponse.setResponseBody(response.getBody().asString());
		restResponse.setResponseCode(response.getStatusCode());

		System.out.println(response.getBody().asString());
		new RestValidator(restResponse).validateStatusCode(Constant.badRequestStatusCode);
	}

	@Test(description = "Retrieve the weather data for an invalid location.")
	public void testGetWeatherDataForInValidLatitudeAndLongitude() {
		Response response = GetRequest.getWithHeaderQueryParamsOfLongitudeAndLatitude("", "", Constant.getCurrentWeatherDetails);

		restResponse.setResponseBody(response.getBody().asString());
		restResponse.setResponseCode(response.getStatusCode());

		System.out.println(response.getBody().asString());
		new RestValidator(restResponse).validateStatusCode(Constant.badRequestStatusCode);
	}

	}