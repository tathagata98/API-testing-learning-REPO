package Day1;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.equalTo;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.testng.annotations.Test;

public class httpRequests {

	static int id;

	@Test(priority = 1)
	void getUserList() {
		given()

				.when().get("https://reqres.in/api/users?page=2")

				.then().statusCode(200).body("page", equalTo(2)).log().all();
	}

	@Test(priority = 2)
	void createUser() {
		Map<String,String> data = new LinkedHashMap<>();
		data.put("name","Tathagata");
		data.put("job","Automation Engineer");

		id =given()
				.contentType("application/json")
				.body(data)
				.header("x-api-key","reqres-free-v1")
				.when().post("https://reqres.in/api/users")
				.jsonPath().getInt("id");

		System.out.println(id);

			}

	@Test(priority=3 , dependsOnMethods = { "createUser" })
	void updateUser() {
		Map<String,String> data = new LinkedHashMap<>();
		data.put("name", "Tathagata");
		data.put("job", "Senior Manager");

		given().contentType("application/json").body(data)
				.header("x-api-key", "reqres-free-v1")

				.when().put("https://reqres.in/api/users/" + id)

				.then().statusCode(200).log().all();
		
		System.out.println(id);
	}
	
	@Test(dependsOnMethods = { "updateUser" })
	void deleteUser()
	{
		given()
				.contentType("application/json")
				.header("x-api-key", "reqres-free-v1")

				.when()
		.delete("https://reqres.in/api/users/" + id)

		.then()
		.statusCode(204).log().all();

	}
	
}