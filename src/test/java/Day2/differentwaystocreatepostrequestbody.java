
package Day2;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.io.File;
import java.io.FileReader;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;

public class differentwaystocreatepostrequestbody 
{

	//1) POST request body using Hashmap (First Approach)

	/*
	@Test
	void testPostusinghashmap() {
		HashMap data = new HashMap();
		data.put("name", "Anirban");
		data.put("location", "Tripura");
		data.put("phone", "242535226");

		String coursesArr[] = { "Protractor", "Java" };
		data.put("courses", coursesArr);

		given().contentType("application/json").body(data)

				.when().post("http://localhost:3000/students")

				.then().statusCode(201).body("name", equalTo("Anirban")).body("location", equalTo("Tripura"))
				.body("phone", equalTo("242535226")).body("courses[0]", equalTo("Protractor"))
				.body("courses[1]", equalTo("Java")).log().all();

	}

	@Test(dependsOnMethods = "testPostusinghashmap")
	void testDelete() {
		given()
		.when()
		.delete("http://localhost:3000/students/4")
		.then()
		.statusCode(200).log().all();
	}
	@Test(dependsOnMethods="testDelete")
	void showall()
	{
		given()
		.when()
		.get("http://localhost:3000/students")
		.then()
		.statusCode(200).log().all();
	}
	*/
	
/*	
	//2) POST request using org.json library 
	@Test 
	void testPostusingorgjson() {
		JSONObject data=new JSONObject();
		
		data.put("name", "Anirban");
		data.put("location", "Tripura");
		data.put("phone", "242535226");

		String coursesArr[] = { "Protractor", "Java" };
		data.put("courses", coursesArr);

		given()
		.contentType("application/json")
		.body(data.toString())

				.when()
				.post("http://localhost:3000/students")

				.then().
				statusCode(201)
				.body("name", equalTo("Anirban"))
				.body("location", equalTo("Tripura"))
				.body("phone", equalTo("242535226"))
				.body("courses[0]", equalTo("Protractor"))
				.body("courses[1]", equalTo("Java"))
				.header("Content-Type", "application/json; charset=utf-8")
				.log().all();

	}

	@Test()
	void testDelete(dependsOnMethods="testPostusingorgjson")
	 {
		given()
		.when()
		.delete("http://localhost:3000/students/4")
		.then()
		.statusCode(200).log().all();
	}
	@Test(dependsOnMethods="testDelete")
	void showall()
	{
		given()
		.when()
		.get("http://localhost:3000/students")
		.then()
		.statusCode(200).log().all();
	}
*/
	//3) POST request using POJO class 
		
	/*@Test 
		void testPostusingPOJOmethod() {
			
			pojo_postrequest ob=new pojo_postrequest();
			ob.setName("Anirban");
			ob.setLocation("Tripura");
			ob.setPhone("242535226");
			String coursesArr[] = { "Protractor", "Java" };
			ob.setCourses(coursesArr);
			
			
			given()
			.contentType("application/json")
			.body(ob)

					.when()
					.post("http://localhost:3000/students")

					.then().
					statusCode(201)
					.body("name", equalTo("Anirban"))
					.body("location", equalTo("Tripura"))
					.body("phone", equalTo("242535226"))
					.body("courses[0]", equalTo("Protractor"))
					.body("courses[1]", equalTo("Java"))
					.header("Content-Type", "application/json; charset=utf-8")
					.log().all();

		}
				
		@Test(dependsOnMethods="testPostusingPOJOmethod")
		void testDelete() {
			given()
			.when()
			.delete("http://localhost:3000/students/4")
			.then()
			.statusCode(200).log().all();
		}
		@Test(dependsOnMethods="testDelete")
		void showall()
		{
			given()
			.when()
			.get("http://localhost:3000/students")
			.then()
			.statusCode(200).log().all();
		}
*/
	
	//4) POST request using external JSON file.
	
@Test
 void testpostusingexternaljson() throws Exception
 {
	
	//Retrieving data from JSON object data
	
	File f=new File(".\\body.json");		
		FileReader reader=new FileReader(f);
		JSONTokener jt=new JSONTokener(reader);
		JSONObject data=new JSONObject(jt);
		
		
		given()
		.contentType("application/json")
		.body(data.toString())

				.when()
				.post("http://localhost:3000/students")

				.then().
				statusCode(201)
				.body("name", equalTo("Anirban"))
				.body("location", equalTo("Tripura"))
				.body("phone", equalTo("242535226"))
				.body("courses[0]", equalTo("Protractor"))
				.body("courses[1]", equalTo("Java"))
				.header("Content-Type", "application/json; charset=utf-8")
				.log().all();

	}
			
	@Test(dependsOnMethods="testpostusingexternaljson")
	void testDelete() {
		given()
		.when()
		.delete("http://localhost:3000/students/4")
		.then()
		.statusCode(200).log().all();
	}
	@Test(dependsOnMethods="testDelete")
	void showall()
	{
		given()
		.when()
		.get("http://localhost:3000/students")
		.then()
		.statusCode(200).log().all();
	}	
 }

