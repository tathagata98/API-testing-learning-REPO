package Day5;

import java.io.File;
import static io.restassured.RestAssured.given;
import org.testng.annotations.Test;


public class singlefileuploadanddownload_forstaticvalue 
{
	@Test
void singlefileupload()
{
		
		// Here no response object value is getting shared
		
	File f=new File("C:\\Users\\Tathagata\\Desktop\\STUDY MATERIAL\\employee.txt");
	
	given()
	.multiPart("file",f)
	.contentType("multipart/form-data")
	
	.when()
	.post("http://localhost:8080/uploadFile")
	
	.then()
	.statusCode(200)
	
	.log().all();
	
}
	@Test(priority=2)
void singlefiledownlaodcheck()
{
	given()
	.when()
	.get("http://localhost:8080/downloadFile/employee.txt")
	.then()
	.statusCode(200)
	.log().all();
}
}
