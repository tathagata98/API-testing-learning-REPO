package Day6;

import org.testng.annotations.Test;

import io.restassured.matcher.RestAssuredMatchers;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;


public class XMLSchemavalidations 
{
	@Test
void xmlvalidator()
{
	given()
	.when()
	.get("http://restapi.adequateshop.com/api/Traveler")
	.then()
	.assertThat().body(RestAssuredMatchers.matchesXsdInClasspath("traveller.xsd"));
}
}
