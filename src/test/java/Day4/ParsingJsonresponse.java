package Day4;

import static io.restassured.RestAssured.given;

import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class ParsingJsonresponse 
{
	String locations;
	boolean status=false;
	String price;
	String typeofresponse;
	Response res;
@Test
	void testJsonResponse()
	{
	
	// Approach 1
	
	/*given()
	.contentType(ContentType.JSON)
	.when()
	.get("http://localhost:3000/store")
	.then()
	.statusCode(200)
	.header("Content-Type", "application/json; charset=utf-8")
	.body("Identities[2].phone", equalTo("9875434446"));
	
*/
	//Approach 2
	/*Response res = given()
	.contentType(ContentType.JSON)
	.when()
	.get("http://localhost:3000/store");
	
	Assert.assertEquals(res.getStatusCode(), 200);
	Assert.assertEquals(res.getHeader("Content-Type"), "application/json; charset=utf-8");
	Assert.assertEquals(res.jsonPath().get("Identities[2].phone").toString(), "9875434446");
	
	JSONObject ob=new JSONObject(res.asString());
	for(int i=0;i<ob.getJSONArray("Identities").length();i++)
	{
		String locations= ob.getJSONArray("Identities").getJSONObject(i).get("location").toString();
		System.out.println(locations);
	}
*/
	//Approach 3
	 res = given()
			.contentType(ContentType.JSON)
			.when()
			.get("http://localhost:3000/data");
	typeofresponse=res.asString();
			if(typeofresponse.startsWith("{"))
			{
				parsing1();
			}
			else if(typeofresponse.startsWith("["))
			{
			parsing2();	
			}
			}

void parsing1()
{
	JSONObject ob=new JSONObject(res.asString());
	for(int i=0;i<ob.getJSONArray("Identities").length();i++)
	{
		locations= ob.getJSONArray("Identities").getJSONObject(i).get("location").toString();
		System.out.println(locations);
	if(locations.equals("Bangalore"))
	{
		status=true;
		System.out.println("Record matching");
		break;
		
	}
	}
	Assert.assertEquals(status, true);
	
	double totalprice=0;
	for(int i=0;i<ob.getJSONArray("Identities").length();i++)
	{
		price= ob.getJSONArray("Identities").getJSONObject(i).get("phone").toString();
		totalprice+=Double.parseDouble(price);
	}			
	System.out.println(totalprice);
	
	Assert.assertEquals(totalprice, 15430);

}
void parsing2()
{
JSONArray ob=new JSONArray(res.asString());
}
}