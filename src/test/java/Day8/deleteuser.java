package Day8;

import static io.restassured.RestAssured.given;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import Utilities.util;

public class deleteuser 
{
	int id;
	String deleteuser_url="/{id}";
@Test
	void test_deleteuser(ITestContext context)
	{
	id =(Integer) context.getSuite().getAttribute("user_id");
	given()
	.headers("Authorization","Bearer "+util.bearertoken)
	.pathParam("id", id)
	.when()
	.delete(deleteuser_url)
	.then()
	.statusCode(204)
	.log().body();
	System.out.println("This is the delete user method with no body content");
	
	System.out.println("==============================");
	 
	}
}
