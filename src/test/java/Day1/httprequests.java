package Day1;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.util.HashMap;

import org.testng.annotations.Test;

public class httprequests {

	static int id;

	@Test(priority = 1)
	void getuserlist() {
		given()

				.when().get("https://reqres.in/api/users?page=2")

				.then().statusCode(200).body("page", equalTo(2)).log().all();
	}

	@Test(priority = 2)
	void createUser() {
		HashMap data = new HashMap();
		data.put("name", "Tathagata");
		data.put("job", "Automation Engineer");

		id = given().contentType("application/json").body(data)

				.when().post("https://reqres.in/api/users").jsonPath().getInt("id");

		System.out.println(id);

		//.then().statusCode(201).log().all();

	}

	@Test(priority=3 , dependsOnMethods = { "createUser" })
	void updateUser() {
		HashMap data = new HashMap();
		data.put("name", "Tathagata");
		data.put("job", "Senior Manager");

		given().contentType("application/json").body(data)

				.when().put("https://reqres.in/api/users/" + id)

				.then().statusCode(200).log().all();
		
		System.out.println(id);
	}
	
	@Test(dependsOnMethods = { "updateUser" })
	void deleteUser()
	{
		given()

		.when()
		.delete("https://reqres.in/api/users/" + id)

		.then()
		.statusCode(204).log().all();

	}
	
}