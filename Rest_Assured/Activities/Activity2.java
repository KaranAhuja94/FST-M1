package restassuredactivities;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

import static org.hamcrest.CoreMatchers.equalTo;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.parsing.Parser;
import io.restassured.response.Response;

public class Activity2 {
	
	String BASE_URL = "https://petstore.swagger.io/v2/user";
	
	@Test(priority = 1)
	public void createUser() {
		
		String requestBody = "{"
				+ "  \"id\": 1006,"
				+ "  \"username\": \"karanahuja2\","
				+ "  \"firstName\": \"Karan\","
				+ "  \"lastName\": \"Ahuja\","
				+ "  \"email\": \"karanahuja@example.com\","
				+ "  \"password\": \"karanahuja\","
				+ "  \"phone\": \"8237461972\""
				+ "}";
		
		Response response = given().contentType(ContentType.JSON).body(requestBody)
				.when().post(BASE_URL);
		
		System.out.println(response.asPrettyString());
		
		response.then().body("code",equalTo(200));
		response.then().body("message", equalTo("1006"));
	}
	
	@Test(priority = 2)
	public void getUser() {
		
		
		Response response = given().contentType(ContentType.JSON)
				.when().pathParam("username", "karanahuja2").get(BASE_URL + "/{username}");
		
		System.out.println(response.asPrettyString());
		
		response.then().body("id", equalTo(1006));
		response.then().body("username", equalTo("karanahuja2"));
		response.then().body("firstName", equalTo("Karan"));
		response.then().body("lastName", equalTo("Ahuja"));
		response.then().body("email", equalTo("karanahuja@example.com"));
		response.then().body("password", equalTo("karanahuja"));
		response.then().body("phone", equalTo("8237461972"));		
		
	}
	
	@Test(priority = 3)
	public void deleteUser() {
		
		RestAssured.defaultParser = Parser.JSON;
		
		Response response = given().contentType(ContentType.JSON)
				.when().pathParam("username", "karanahuja2").delete(BASE_URL + "/{username}");
		
		System.out.println(response.asPrettyString());
		
		response.then().body("code", equalTo(200));
		response.then().body("message", equalTo("karanahuja2"));
		
	}
}
