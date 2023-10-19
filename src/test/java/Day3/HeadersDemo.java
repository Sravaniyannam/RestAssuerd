package Day3;

import org.testng.annotations.Test;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import static io.restassured.matcher.RestAssuredMatchers.*;

import static org.hamcrest.Matchers.*;

public class HeadersDemo {
	//@Test(priority=1)
	void testHeaders()
	{
		given()
		.when()
		   .get("https://www.google.com/")
		   
		   .then()
		     .header("Content-type","text/html; charset=ISO-8859-1")
		     .and()
		     .header("Content-encoding", "gzip")
		     .and()
		     .header("server","gws")
		     .log().all();
		     
		
		
	}
	
	@Test(priority=2)
	
	void getHeaders() {
		
	Response res = given()
		.when()
		   .get("https://www.google.com/");
	
	//get single header info
	//String headervalue=res.getHeader("Content-type");
	//System.out.println("The value of Content-type header is:"+headervalue);
	
	//get all headers info
    Headers	myheaders=res.getHeaders();
    
    for(Header hd:myheaders)
    {
    	System.out.println(hd.getName()+"        "+hd.getValue());
    }
    
		   
		  
		
	}

	
	}


