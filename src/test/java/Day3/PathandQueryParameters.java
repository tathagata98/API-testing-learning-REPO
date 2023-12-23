package Day3;


import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class PathandQueryParameters 
{
	
	//https://reqres.in/api/users?page=2&id=5

@Test
	void testqueryandpathparameters()
	{
		given()
		.pathParam("mypathparam", "users")
		.queryParam("page", 2)
		.queryParam("id", 5)
		
		.when()
		.get("https://reqres.in/api/{mypathparam}")
		
		.then()
		.statusCode(200)
		.log().all();
	}
}
