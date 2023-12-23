package Day8;

import static io.restassured.RestAssured.given;

import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import Utilities.util;

public class updateuser
{
	int id;
	String updateuser_url="/{id}";
	@Test
void test_updateuser(ITestContext context)
{
		id=(Integer) context.getSuite().getAttribute("user_id");
		Faker faker=new Faker();
		JSONObject data=new JSONObject();
		
		data.put("name", faker.name().fullName());
		data.put("gender", "Male");
		data.put("email", faker.internet().emailAddress());
		data.put("status", "Active");
		
		//initialization();
		
		given()
		.headers("Authorization","Bearer "+util.bearertoken)
		.contentType("application/json")
		.body(data.toString())
		.pathParam("id", id)
		
		.when()
		.put(updateuser_url)
		
		.then()
		.statusCode(200)
		.log().body();
				 
		 System.out.println("This is the update user method, displaying the updated values ");

		 System.out.println("==============================");
		 

		
}
}
