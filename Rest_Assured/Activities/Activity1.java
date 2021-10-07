package restassuredactivities;

import org.testng.annotations.Test;	

import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.equalTo;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Activity1 {
	
	String BASE_URI ="https://petstore.swagger.io/v2/pet";
	
	@Test(priority = 1)
	public void postRequest() {
		
		String requestBody = "{"
				+ "  \"id\": 77233,"
				+ "  \"name\": \"Tobbler\","
				+ "  \"status\": \"alive\""
				+ "}";
		
		Response response = given().contentType(ContentType.JSON).body(requestBody)
							.when().post(BASE_URI);
		
		response.then().body("id", equalTo(77233));
		response.then().body("name", equalTo("Tobbler"));
		response.then().body("status",equalTo("alive"));
	}
	
	@Test(priority = 2)
	public void getRequest() {
		
		Response response = given().contentType(ContentType.JSON)
							.when().pathParam("petId", "77233").get(BASE_URI + "/{petId}");
		
		response.then().body("id", equalTo(77233));
		response.then().body("name", equalTo("Tobbler"));
		response.then().body("status",equalTo("alive"));
		
	}
	
	@Test(priority = 3)
	public void deleteRequest() {
		
		Response response = given().contentType(ContentType.JSON)
							.when().pathParam("petId", "77233").delete(BASE_URI + "/{petId}");
		
		response.then().body("code", equalTo(200));
		response.then().body("message",equalTo("77233"));
		
	}
	
	
	
}
