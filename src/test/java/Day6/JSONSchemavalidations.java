package Day6;

import org.testng.annotations.Test;

import io.restassured.module.jsv.JsonSchemaValidator;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;


public class JSONSchemavalidations 
{
@Test
	void JSONSchemavalidation()
	{
	given()
	.when()
	.get("http://localhost:3000/data")
	.then()
	.assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("DetailsJsonSchema.JSON"));
	
	}
}
