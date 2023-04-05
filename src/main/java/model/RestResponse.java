package model;

import io.restassured.http.Header;
import io.restassured.path.json.JsonPath;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RestResponse {
	private int responseCode;
	private String responseBody;
	private JsonPath listMap;
}