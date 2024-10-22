package api.test;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoint.UsersEndpoint;
import api.pojo.UserPojo;
import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.response.Response;

public class UserTest {

	Faker faker;
	UserPojo userPojo;
	UsersEndpoint usersEndpoint;

	@BeforeClass
	public void prepareData() {
		faker = new Faker();
		userPojo = new UserPojo();
		usersEndpoint = new UsersEndpoint();
		userPojo.setId(faker.idNumber().hashCode());
		userPojo.setUsername(faker.name().username());
		userPojo.setFirstName(faker.name().firstName());
		userPojo.setLastName(faker.name().lastName());
		userPojo.setPassword(faker.internet().password());
		userPojo.setPhone(faker.phoneNumber().cellPhone());
		userPojo.setUserStatus((faker.number().randomDigit() % 2 == 0) ? 0 : 1);
		userPojo.setEmail(faker.internet().emailAddress());
		RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());

	}

	@Test(priority = 1)
	private void createUser() {
		// TODO Auto-generated method stub
		Response res = usersEndpoint.createUser(userPojo);
		res.then().statusCode(200);
	}
	
	@Test(priority = 2)
	private void getUser()
	{
		Response res = usersEndpoint.getUser(userPojo.getUsername());
		res.then().statusCode(200);
	}
	
	
	@Test(priority = 3)
	private void updateUser() {
		// TODO Auto-generated method stub
		userPojo.setFirstName(faker.name().firstName());
		userPojo.setLastName(faker.name().lastName());
		userPojo.setPassword(faker.internet().password());
		Response res = usersEndpoint.updateUser(userPojo.getUsername(), userPojo);
		res.then().statusCode(200);
	}
	
	
	@Test(priority = 4)
	private void deleteUser() {
		// TODO Auto-generated method stub
		Response res = usersEndpoint.deleteUser(userPojo.getUsername());
		res.then().statusCode(200);
	}
}
