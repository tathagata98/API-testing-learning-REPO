package Day6;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class serializationanddeserialization 
{
	@Test
	void serialization() throws Exception
{
	//Serialization is converting POJO to Json files.
		StudentPOJO pb=new StudentPOJO();
		String courses[]= {"Selenium","API Automation"};
		pb.setName("Tathagata");
		pb.setLocation("Kolkata");
		pb.setPhone("9875434446");
		pb.setCourses(courses);
       
		ObjectMapper objmapper=new ObjectMapper();
		String jsonbody=objmapper.writerWithDefaultPrettyPrinter().writeValueAsString(pb);
		System.out.println(jsonbody);
		
}
	
	@Test(dependsOnMethods="serialization")
	void de_serialization() throws Exception
	{
		//De-Serialization is converting Json files back to POJO.
		String jsonbody=
				"{"
				+
				  " \"name\" : \"Tathagata\","
					  +
				  "\"location\" : \"Kolkata\","
				  +
				  "\"phone\" : \"9875434446\","
				  +
				  "\"courses\" : [ \"Selenium\", \"API Automation\" ]"
						  +
				"}";
					
		ObjectMapper objmapper=new ObjectMapper();
		StudentPOJO POJOoutput= objmapper.readValue(jsonbody, StudentPOJO.class);
		System.out.println("Name :"+POJOoutput.getName());
		System.out.println("Location :"+POJOoutput.getLocation());
		System.out.println("Phone :"+POJOoutput.getPhone());
		System.out.println("Courses :"+POJOoutput.getCourses()[0]);
		System.out.println(POJOoutput.getCourses()[1]);
	

	}
}
