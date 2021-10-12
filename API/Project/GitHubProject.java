package restassuredproject;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static org.hamcrest.CoreMatchers.equalTo;

public class GitHubProject {
	
	RequestSpecification request;
	String sshKey = "";
	int id;
	
	@BeforeClass
	public void setUp() {
		
		request = new RequestSpecBuilder().setContentType(ContentType.JSON).addHeader("Authorization", "Bearer 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").setBaseUri("https://api.github.com").build();
		
	}
	
	@Test(priority = 1)
	public void addSSHKey() {
		
		String requestbody = "{"
				+ "  \"title\": \"TestApiKey\","
				+ "  \"key\": \"ssh-rsa AAAAB3NzaC1yc2EAAAADAQABAAABgQCpd1d/HJKw6x+eYpd9Uh4TeX79xBer92Kv6b2vg53M9w26kM1ajBp3sTXMCTLnprfR52tMgXri96Zt7QhHPcthCqMw6HKsZJTs+4Si3eedwWcEO/0CI1Mq+mrqLBFkqJjD+JvLTlFcimpVbi8EIoQUviU40CocGsYWtLiFc7Lqy/1etRDDcGOr5lxaboO909kuJ9dOX+vmrTkpM8Wa6YF+BFnwGq1dba/4fhm6uVtnn+jxefjaTKoNfiKf5kiJCSO70u5awfhbN1oiqfaTO/giBQ4iAzF+Odv4OyFpht7UpQ+9TJZJ5YElN6LgVAluIa0cHsIkVQjSXzcZoJJpikjBdPgRNbOdNyVFSYcniutuSK10+VLW5cWl0RnnJpbabBl9gTBJMHLjLpyKxU0il4N7+bdyvL2Wa6Q3XqMZqByvk+PkHc6zsBUFmpGVFERy9+iDN6f4sH42tfcp6PJpQRQRvULrW1oio+PffSas55k9xM7V6Ods2yq5RPIzWjX8lBM=\""
				+ "}";
		
		Response response = given().spec(request).body(requestbody).when().post("/user/keys");
		
		System.out.println(response.body().asPrettyString());
		
		id = response.then().extract().path("id");
		
		response.then().assertThat().statusCode(201);
		
	}
	
	@Test(priority = 2)
	public void getSSHKey() {
		
		Response response = given().log().all().spec(request).when().get("/user/keys");
		
		System.out.println(response.body().asPrettyString());
		
		response.then().assertThat().statusCode(200);
		
	}
	
	@Test(priority = 3)
	public void deleteSSHKey() {
		
		Response response = given().log().all().spec(request).when().pathParam("keyId", id).delete("/user/keys/{keyId}");
		
		System.out.println(response.body().asPrettyString());
		
		response.then().assertThat().statusCode(204);
	}
	
}
