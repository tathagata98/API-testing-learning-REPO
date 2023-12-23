package check;

import static io.restassured.RestAssured.given;

import java.util.List;

import org.testng.annotations.Test;

import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;

public class parsing 
{
	int page_count,i;
		Response res;
		
		@Test()
		void findpagecount()
		{
			res=given()
					
			.when()
			.get("http://restapi.adequateshop.com/api/Traveler");
	
			page_count=res.xmlPath().getInt("TravelerinformationResponse.total_pages");
			
			System.out.println("Total number of pages are : - "+page_count);
	
		}
		@Test(dependsOnMethods="findpagecount")
		void testXMLParsing()
		{
		for(i=1;i<=page_count;i++)
		{
			
			 res=given()
			.queryParam("page", i)
			
			.when()
			.get("http://restapi.adequateshop.com/api/Traveler");
			 
			
			XmlPath obj= new XmlPath(res.asString());

			List<String> travellernames=obj.getList("TravelerinformationResponse.travelers.Travelerinformation.name");
			
			for(String traveller:travellernames)
			{
			System.out.println(traveller);
			}
			
			System.out.println(" End of page " +i+ " ------------------------------------ ");
	}
		
}
}

