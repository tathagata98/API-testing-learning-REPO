package Utilities;

import io.restassured.RestAssured;
public class util 
{
	public static String bearertoken="4a0a65f99ed387c4aad803fdf5a2dd03528023f94c54ee8418e6888f88171b48";
	public static String baseUri="https://gorest.co.in";
	public static String basePath="public/v2/users";

	
	public static void initialization()
	{
		RestAssured.baseURI=util.baseUri;
		RestAssured.basePath=util.basePath;
	}
		
}
