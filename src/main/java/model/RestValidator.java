package model;

import org.testng.Assert;

public class RestValidator{
	private RestResponse response;

	public RestValidator(RestResponse response) {
		this.response = response;
	}

	public RestValidator validateStatusCode(int expectedCode) {
		Assert.assertEquals(response.getResponseCode(), expectedCode, "Incorrect Response Code");
		return this;
	}
	public RestValidator validateCityName(String expectedCityName){
		Assert.assertEquals(response.getListMap().get("data[0].city_name"),expectedCityName,"City name is not as per expected");
		return this;
	}
	public RestValidator validateCountryCode(String expectedCountryCode){
		Assert.assertEquals(response.getListMap().get("data[0].country_code"),expectedCountryCode, "Country code is different then what is expected");
		return this;
	}
}
