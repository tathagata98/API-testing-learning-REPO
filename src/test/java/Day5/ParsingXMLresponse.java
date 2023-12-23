package Day5;

import static io.restassured.RestAssured.given;

import java.util.List;

import org.testng.annotations.Test;

import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;


public class ParsingXMLresponse 
{
	String record="Developer";
	
	@Test
	void testXMLResponse()
	{
		boolean status=false;
		// Approach 1

		/*
	given()
	
	.when()
	.get("http://restapi.adequateshop.com/api/Traveler?page=1")
	
	.then()
	.statusCode(200)
	.header("Content-Type", "application/xml; charset=utf-8")
	.body("TravelerinformationResponse.page", equalTo("1"))
	.body("TravelerinformationResponse.travelers.Travelerinformation[0].name", equalTo("Developer"))
	.log().all();
	
	*/
	
	//2nd Approach
	
	/*
	Response res = given()
	
	.when()
	.get("http://restapi.adequateshop.com/api/Traveler?page=1");
	
	Assert.assertEquals(res.getStatusCode(), 200);
    
	//We can go with res.getHeader or res.Header it returns the same value
	Assert.assertEquals(res.getHeader("Content-Type"), "application/xml; charset=utf-8");
	String pageno=res.xmlPath().get("TravelerinformationResponse.page").toString();
    Assert.assertEquals(pageno, "1");
    String name=res.xmlPath().get("TravelerinformationResponse.travelers.Travelerinformation[0].name").toString();
    Assert.assertEquals(name, "Developer");
    
    */
		
	//3rd Approach 
	
		
		Response res = given()
			
				.when()
				.get("http://restapi.adequateshop.com/api/Traveler?page=1");
				
				XmlPath obj= new XmlPath(res.asString());

				List<String> travellernames=obj.getList("TravelerinformationResponse.travelers.Travelerinformation.name");
				
				for(String traveller:travellernames)
				{
				System.out.println(traveller);
				}
					for(String travellers:travellernames)
					{
					if(travellers.equals(record))
					{
						status=true;
						System.out.println("The record " +record+ " is found");
						break;
					}
					else
					{
						System.out.println("Record " +record+ " is not found");
						break;
					}
				
				}
				
}
}
