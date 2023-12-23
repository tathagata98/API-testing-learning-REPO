package Day8;

import static io.restassured.RestAssured.given;

import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import Utilities.util;

public class Createuser {
	/*
	// No need of this part just for understanding
	//void  testuser()
	{
		initialization();
	
	}
	
	//public static void main(String args[])throws Exception
	{
	Createuser ob=new Createuser();
	ob.testuser();
	String value=ob.basePath;
	ob.initialization();
	System.out.println(value);
	}
*/
	@Test
	void test_createuser(ITestContext context)
	{
		Faker faker=new Faker();
		JSONObject data=new JSONObject();
		
		data.put("name", faker.name().fullName());
		data.put("gender", "Male");
		data.put("email", faker.internet().emailAddress());
		data.put("status", "Inactive");
		
		util.initialization();
		
		
		int id=given()
		.headers("Authorization","Bearer "+util.bearertoken)
		.contentType("application/json")
		.body(data.toString())
		
		.when()
		.post()
		.jsonPath().getInt("id");
		
		 
		 System.out.println("This is the Create user method, generating id :" +id);
		 
		 System.out.println("==============================");
		 context.getSuite().setAttribute("user_id", id);
		
	}

}
