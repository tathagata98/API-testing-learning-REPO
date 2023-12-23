package Day7;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class Authentication 
{
	static String baseUri="https://api.trello.com";
	static String basePath="/1/boards";
	//@Test
void testbasicAuthentication()
{
	given()
      .auth().basic("postman", "password")
	.when()
	.get("https://postman-echo.com/basic-auth")
	.then()
	.statusCode(200)
	//.log().body() //Can use log.body to print only the contents of the body
	.body("authenticated", equalTo(true))
	.log().all();
	
}
	//@Test(priority=2)
	void testdigestAuthentication()
	{
		given()
	      .auth().digest("postman", "password")
		.when()
		//.get("https://postman-echo.com/digest-auth")// Go for any url here the answer will be the same 
		.get("https://postman-echo.com/basic-auth")
		.then()
		.statusCode(200)
		//.log().body() //Can use log.body to print only the contents of the body
		//.body("authenticated", equalTo(true))
		.log().all();
		
	}
	//@Test(priority=3)
	void testpremptiveAuthentication()
	{
		//Here for preemptive authentication 
		given()
	      .auth().preemptive().basic("postman", "password")
		.when()
		.get("https://postman-echo.com/basic-auth")
		.then()
		.statusCode(200)
		//.log().body() //Can use log.body to print only the contents of the body
		//.body("authenticated", equalTo(true))
		.log().all();
	}
	//@Test(priority=4)
	void testbearertokenauthentication()
	{
		String my_token="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";
		
		given()
		.headers("Authorization","Bearer "+my_token)
		
		.when()
		.get("https://api.github.com/user/repos")
		
		.then()
		.statusCode(200).log().all();
		
	}
	//@Test
	// Not running this test because we don't have data for running a OAuth1 authentication
	void testoauth1()
	{
		given()
		.auth().oauth("consumerKey", "consumerSecret", "accessToken", "secretToken")
		// this is OAuth1 authentication, here we need multiple keys
		.when()
		.get()
		.then()
		.statusCode(200);
	}
	//@Test(priority=5)
	void testoauth2()
	{
		given()
		.auth().oauth2("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")
		.when()
		.get("https://api.github.com/user/repos")
		.then()
		.statusCode(200)
		.log().all();
	}
	@Test(priority=6)
	void testAPIkeyAuthentication()
	{
		RestAssured.baseURI=baseUri;
		RestAssured.basePath=basePath;
		
		given()
		.queryParam("key", "afe05d1e1f61f86d6a3e44fe8d843840")
		.queryParam("token","9614ef2db4e4b826d23ce76ff43c20e9faf5617392c2fcd92e59a0e0e2278514")
		.pathParam("mypath", "644ebc1f1b7419aa8e6314d1")
		.when()
		.get("/{mypath}")
		.then()
		.statusCode(200).log().body();
	}
}
