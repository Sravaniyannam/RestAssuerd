package Day1;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

import static io.restassured.matcher.RestAssuredMatchers.*;

import static org.hamcrest.Matchers.*;

import java.util.HashMap;


public class HTTPRequests {
	
	private String id;


	@Test(priority=1)
	void getUser()
	
	{
		int id;
	   given()
       .when()
	       .get("https://reqres.in/api/users?page=2")
	      .then()
	      .statusCode(200)
	      .body("page", equalTo(2))
	      .log().all();

}
	
	@Test(priority=2)
	 void createUser()
	 {
		HashMap data=new HashMap();
		data.put("name","Sravani");
		data.put("job","trainer");
		

	     int id = given()
		.contentType("application/json")
		.body(data)
		
		.when()
		.post("https://reqres.in/api/users")
		.jsonPath().getInt("id");
		
	//	.then()
	//	.statusCode(201)
	//	.log().all();
		
	 }
	
	
	@Test(priority=3)
	void  updateUser()
	{
	
		HashMap data=new HashMap();
		data.put("name","Mahi");
		data.put("job","teacher");
		

	    
		
		given()
		.contentType("application/json")
		.body(data)
		
		.when()
		.post("https://reqres.in/api/users"+id)
		
		
		.then()
		.statusCode(201)
		.log().all();
	}
	
	@Test(priority=4)
	
	void deleteUser()
	{
		
		given()
        .when()
        .get("https://reqres.in/api/users/"+id)
        .then()
        .statusCode(404)
        .log().all();
	}
	
	
	
	
	 
}