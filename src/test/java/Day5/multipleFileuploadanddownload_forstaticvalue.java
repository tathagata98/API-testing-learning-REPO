package Day5;

import static io.restassured.RestAssured.given;

import java.io.File;

import org.testng.annotations.Test;

public class multipleFileuploadanddownload_forstaticvalue 
{
	@Test
		void multipleFileupload()
		{
			
			// Approach 1
			
			File file1=new File("C:\\Users\\Tathagata\\Desktop\\STUDY MATERIAL\\employee.txt");
			File file2=new File("C:\\Users\\Tathagata\\Desktop\\STUDY MATERIAL\\Selenium notes.txt");
			given()
	        .multiPart("files",file1)
	        .multiPart("files",file2)
	        .contentType("multipart/form-data")
			
	        .when()
			.post("http://localhost:8080/uploadMultipleFiles")
			
			.then()
			.statusCode(200)
			.log().all();
		}
		
		//@Test
		void multipleFileuploads()
		{
			
			// Approach 2
			// This approach is not working here, because of the development of the API's by the developers
			
			File file1=new File("C:\\Users\\Tathagata\\Desktop\\STUDY MATERIAL\\employee.txt");
			File file2=new File("C:\\Users\\Tathagata\\Desktop\\STUDY MATERIAL\\Selenium notes.txt");
			
			File filearr[]= {file1,file2}; 
			given()
	        .multiPart("files",filearr)
	        .contentType("multipart/form-data")
			
	        .when()
			.post("http://localhost:8080/uploadMultipleFiles")
			
			.then()
			.statusCode(200)
			.log().all();
		}
		

}
