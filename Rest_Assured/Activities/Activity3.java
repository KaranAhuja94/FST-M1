package restassuredactivities;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.parsing.Parser;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.equalTo;

public class Activity3 {
	
	RequestSpecification reqSpecification;
	ResponseSpecification resSpecification;
	
	@BeforeClass
	public void setUp() {
		
		reqSpecification = new RequestSpecBuilder().setContentType(ContentType.JSON)
				.setBaseUri("https://petstore.swagger.io/v2/pet").build();
		
		resSpecification = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON)
				.expectBody("status", equalTo("alive")).build();
	}
	
	@DataProvider
	public Object[][] getDataProvider() {
		
		Object[][] data = new Object[][] {{5012,"Riley","alive"},{5014,"Hansel","alive"}};
		return data;
		
	}
	
	@Test(priority = 1)
	public void addPets() {
		
		String requestBody = "{"
				+ "  \"id\": 5012,"
				+ "  \"name\": \"Riley\","
				+ "  \"status\": \"alive\""
				+ "}";
		
		Response response = given().spec(reqSpecification).body(requestBody)
				.when().post();
		
		response.then().spec(resSpecification);
		
		requestBody = "{"
				+ "  \"id\": 5014,"
				+ "  \"name\": \"Hansel\","
				+ "  \"status\": \"alive\""
				+ "}";
		
		response = given().spec(reqSpecification).body(requestBody).when().post();
		
		response.then().spec(resSpecification);
		
	}
	
	@Test(dataProvider = "getDataProvider",priority = 2)
	public void getPets(int id, String name, String status) {
		
		Response response = given().spec(reqSpecification).pathParam("petId", id).when().get("/{petId}");
		
		System.out.println(response.asPrettyString());
		
		response.then().spec(resSpecification);
		
	}
	
	@Test(dataProvider = "getDataProvider",priority = 3)
	public void deletePet(int id, String name, String status) {
		
		RestAssured.defaultParser = Parser.JSON;
		
		Response response = given().spec(reqSpecification).pathParam("petId", id).when().delete("/{petId}");
		
		System.out.println(response.asPrettyString());
		
		response.then().body("code", equalTo(200));
		
	}
	
	
}
