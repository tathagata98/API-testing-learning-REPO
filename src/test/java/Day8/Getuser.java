package Day8;

import static io.restassured.RestAssured.given;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import Utilities.util;

public class Getuser
{
	int id;
	String getuser_url="/{id}";
	
	@Test
void test_getuser(ITestContext context)
{
	id=(Integer) context.getSuite().getAttribute("user_id");
	
	//initialization();
	
	given()
	.headers("Authorization","Bearer "+util.bearertoken)
	.pathParam("id",id)
	.when()
	.get(getuser_url)
	.then()
	.statusCode(200).log().body();
	
	System.out.println("This is the Get user method displaying the user created in : Create method ");
	 
	 System.out.println("==============================");
	 
		
}
}
