package Day3;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import static io.restassured.matcher.RestAssuredMatchers.*;

import static org.hamcrest.Matchers.*;

import java.util.Map;


public class PathAndQueryParameters {
	
	//https://reqres.in/api/users?page=2&id=5
	 
	//@Test(priority=1)
	void  testQueryAndPathParameters()
	{
		
		given()
		.pathParam("mypath","users")    //path parameters
		.queryParam("page",2)           //query parameters
		.queryParam("id",5)             //query parameters
		
		.when()
		  .get("https://reqres.in/api/{mypath}")
		.then()
		.cookie()
		.log().all();
		
		  
	}
	
	@Test(priority=2)
	void getCookiesInfo()
	{
		Response res= given()
				
				.when()
				.get("https://www.google.com/");
				
				//get single cookie info
				
			//	String cookie_value=res.getCookie("AEC");
		    //   System.out.println("value of cookie is ====>"+cookie_value);
		
		
		       
		       //get all cookies info
		  Map<String,String>  cookies_values=res.getCookies();
		 // System.out.println(cookies_values.keySet());
		  
		  for (String k:cookies_values.keySet())
		  {
			  String cookie_value=res.getCookie(k);
			  System.out.println(k+"         "+cookie_value);
			  
			  
		  }
		  
		  
		       
		       
		       
		       
		       
		       
		       
		       
	}
	
}	
				
				
		