package Day7;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

import static io.restassured.matcher.RestAssuredMatchers.*;

import static org.hamcrest.Matchers.*;

public class Authentications {
	
	@Test(priority=1)
	
    void testBasicAuthentication()
    {
		given()
		  .auth().basic("postman","password")
		  
	   .when()
	      .get("https://postman-echo.com/basic-auth")
	      
	      
	   .then()
	   . statusCode(200)
	   .body("authenticated", equalTo(true))
	   .log().all();
    }

@Test(priority=2)
	
    void testDigestAuthentication()
    {
		given()
		  .auth().digest("postman","password")
		  
	   .when()
	      .get("https://postman-echo.com/basic-auth")
	      
	      
	   .then()
	   . statusCode(200)
	   .body("authenticated", equalTo(true))
	   .log().all();
    }
@Test(priority=3)

void testPreemptiveAuthentication()
{
	given()
	  .auth().preemptive().basic("postman","password")
	  
   .when()
      .get("https://postman-echo.com/basic-auth")
      
      
   .then()
   . statusCode(200)
   .body("authenticated", equalTo(true))
   .log().all();
}




@Test(priority=4)

void testBearerTokenAuthentication() {



	String bearerToken ="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";



	given()

	.headers("Authorization","Bearer"+bearerToken)   //   here Bearer is coming from header in postman, and we need to pass bearerToken as well

	//.headers("Authorization","Bearer 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")  // 59 th line String bearerToken lekpoyina direct ga elaa rayochhu



	.when()

	.get("https://api.github.com/user/repos")



	.then()

	.statusCode(200)

	.log().all();

}

     @Test
     void testOuth1Authentication()
     {
    	 given()
    	 .auth().oauth("consumerkey","consumerSecrat","accessToken","tokenSecrate") //this is for oauth1.0 authentication
    	 
    	 
    	 .when()
    	    .get("url")
           
    	 .then()
    	   .statusCode(200)
    	   .log().all();
    	     
     }
       
     @Test
     void testOuth2Authentication()
     {
    	 given()
    	 
    	    .auth().oauth2("ghp_24pH0IcZ1PKHC1qOtLwj57AuDYmtSz2fuYKP")
    	 .when()
    	    .get("https://api.github.com/user/repos")
    	    
    	    .then()
    	       .statusCode(200)
    	       .log().all();
    	    
     }
     
     
     	}

