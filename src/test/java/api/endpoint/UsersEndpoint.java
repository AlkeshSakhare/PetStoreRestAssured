package api.endpoint;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import api.pojo.UserPojo;
import io.restassured.http.ContentType;
import io.restassured.response.Response;


public class UsersEndpoint {

	public  Response createUser(UserPojo user) {
		// TODO Auto-generated method stub
		
		return given()
		.accept(ContentType.JSON)
		.contentType(ContentType.JSON)
		.body(user)		
		.when()
		.post(Routes.createUser);
	}

	public  Response getUser(String username) {
		// TODO Auto-generated method stub
		
		return given()
		.pathParam("username", username)	
		.when()
		.get(Routes.getUser);
		
		
	}	
	
	public  Response updateUser(String username,UserPojo user) {
		// TODO Auto-generated method stub
		
		return given()
			.pathParam("username", username)	
			.accept(ContentType.JSON)
			.contentType(ContentType.JSON)
			.body(user)		
		.when()
			.put(Routes.updateUser);
		
	}	
	
	public  Response deleteUser(String username) {
		// TODO Auto-generated method stub
		
		return given()
				.pathParam("username", username)	
		.when()
		.delete(Routes.deleteUser);
	}
}
