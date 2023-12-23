package Day3;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class headersdemo 
{
	@Test(priority=1)
	void validateheaders()
	{
	given()

	.when()
	.get("https://www.google.com/")

	.then()
	.header("Content-Type", "text/html; charset=ISO-8859-1")
	.and()
	.header("Content-Encoding","gzip")
	.and()
	.header("Server","gws")
	.log().headers();
	
	}
		
		@Test(priority=2)
		
		void captureheaders() throws Exception
		{
			Response res=given()

			.when()
			.get("https://www.google.com/");

			//Get single header info
			
			System.out.println("The value of the header Content-Type is : " +res.getHeader("Content-Type"));
			
			//Get multiple headers info
			//System.out.println(res.getHeaders());
			
			//You can try this method to display all the headers in the console using Java logic.
			Headers myheaders = res.getHeaders();
			for(Header header:myheaders)
			{
				System.out.println(header.getName()+"       "+header.getValue());
			}
	
		}
}
