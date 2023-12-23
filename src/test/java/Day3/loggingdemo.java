package Day3;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class loggingdemo 
{
	@Test
void loggingtest()
{
given()

.when()
.get("https://reqres.in/api/users?page=2")
.then()
//.log().body()  Print only body response
//.log().cookies() Print only cookies response
//.log().headers() Print only  headers responses
.log().all(); //Print all the response

}
	
}

