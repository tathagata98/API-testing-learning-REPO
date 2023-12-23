package check;


import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import java.io.File;
import java.net.URI;
import java.util.List;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class Fileuploadanddownload_fordynamicvalue 
{
	Response res;
	String responses;
	List<String>responsess;
	//@Test
	void singleFileupload()
	{
		File f=new File("C:\\Users\\Tathagata\\Desktop\\STUDY MATERIAL\\employee.txt");
		
		Response res=given()
        .multiPart("file",f)
        .contentType("multipart/form-data")
		
        .when()
		.post("http://localhost:8080/uploadFile");
		
		String totalresponse=res.jsonPath().prettify();
		
		System.out.println("The JSON BODY------>"+totalresponse);
		
		responses=res.jsonPath().getString("fileDownloadUri");
		
		System.out.println(responses);
		
	}
	//@Test(dependsOnMethods="singleFileupload")
	void singlefiledownloadcheck()
	{
		res = given()
				
		.when()
		.get(responses);
		
		res.print();
	}

	@Test
	void multipleFileupload()
	{
		File f1=new File("C:\\Users\\Tathagata\\Desktop\\STUDY MATERIAL\\employee.txt");
		File f2=new File("C:\\Users\\Tathagata\\Desktop\\STUDY MATERIAL\\Seleniumnotes.txt");
		
		
		Response res=given()
        .multiPart("files",f1)
        .multiPart("files",f2)
        .contentType("multipart/form-data")
		
        .when()
		.post("http://localhost:8080/uploadMultipleFiles");
		
		String totalresponse=res.jsonPath().prettify();
		System.out.println("The JSON BODY------>" + totalresponse);
		
	    responsess=res.jsonPath().getList("fileDownloadUri");
		System.out.println(responsess);
		
	}
	@Test(dependsOnMethods="multipleFileupload")
	void multiplefiledownloadcheck()
	{
		for(String responses:responsess)
		{
			
		res = given()
				
		.when()
		.get(responses);
		
		
		
		res.print();
	}
			
}
}
