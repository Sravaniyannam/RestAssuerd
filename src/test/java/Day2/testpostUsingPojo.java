package Day2;
import org.json.JSONObject;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

import static io.restassured.matcher.RestAssuredMatchers.*;

import static org.hamcrest.Matchers.*;

import java.util.HashMap;



public class testpostUsingPojo {
	
	// post request body using pojo class
	
	Pojo_PostRequest data= new Pojo_PostRequest();
	
	 data.setName("Sravani");
	 data.setLocation("France");
	 data.setPhone("123456");
	 
	 String CoursesArr[]= {"c","c++"};
	 data.setCourses(CoursesArr);
	 
	 
	
	given()
	.contentType("application/json")
	.body(data)
	
	.when()
	 .post("https://localhost:3000/students")
	 
	 .then()
	   .statusCode(201)
	   .body("name",equalTo("Sravani"))
	   .body("location",equalTo("France"))
	   .body("phone",equalTo("123456"))
	   .body("courses[0]",equalTo("c"))
	   .body("courses[1]",equalTo("c++"))
	   .header("Content-Type", "application/json; charset=utf-8")
	   .log().all();


}
	

}
