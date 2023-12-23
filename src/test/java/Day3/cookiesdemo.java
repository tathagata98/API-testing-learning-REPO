package Day3;

import static io.restassured.RestAssured.given;

import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class cookiesdemo 
{
	
	//@Test(priority=1)
void displaysapioutputinconsole()
{
given()

.when()
.get("https://www.google.com/")

.then()
.log().all();
}
	
	@Test(priority=2)
	
	void displaycookies() throws Exception
	{
		Response res=given()

		.when()
		.get("https://www.google.com/");

		//Get single cookie info ; Here AEC is a specific cookie name already extracted in POSTMAN
		//System.out.println(res.cookie("AEC"));
		//System.out.println(res.getCookie("AEC"));
		
		//Extracting multiple cookies data
		//System.out.println(res.getCookies());
		
		//You can try the above approach or go for Java for-each loop approach for better output;
		
		Map<String,String> cookies=res.getCookies();
		
		for(String cookie_name:cookies.keySet())
		{
			String cookie_value=res.getCookie(cookie_name);
			System.out.println(cookie_name+ "         " +cookie_value);
		}
		
	}
	
}

