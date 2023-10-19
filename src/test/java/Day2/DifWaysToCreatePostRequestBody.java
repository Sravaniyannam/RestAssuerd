package Day2;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

import static io.restassured.matcher.RestAssuredMatchers.*;

import static org.hamcrest.Matchers.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;

public class DifWaysToCreatePostRequestBody {
	
	//post request body using HashMap
	
//	@Test
	
	void testPostUsingHashMap()
	{
		HashMap data= new HashMap();
		
		data.put("name", "Sravani");
		data.put("location","France");
		data.put("phone", "123456");
		
		String courseArr[]= {"c","c++"};
		data.put("courses", "courseArr");
		
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
		   
	}//
	

    @Test(priority=1)
   void testPostUsingJsonLibrary()
   {
    	JSONObject data=new JSONObject();
    	
    	data.put("name", "Sravani");
		data.put("location","France");given()
		.contentType("application/json")
		.body(data.toString())
		
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
		data.put("phone", "123456");
		
		String courseArr[]= {"c","c++"};
		data.put("courses", "courseArr");
		
		given()
		.contentType("application/json")
		.body(data.toString())
		
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
    
    //delete Student record
    @Test(priority=2)
    void testDelete()
    
    {
    	given()
    	
    	.when()
    	  .delete("http://localhots:3000/students/4")
    	  
    	  .then()
    	   .statusCode(200);
    	
    }
    
    //post request body using External json file
    
    @Test(priority =3)
    
    void testPostUsingExternalJsonFile() throws FileNotFoundException
    
    {
    	File f= new File(".\\body.json");
    	FileReader fr= new FileReader(f);
    	
    	JSONTokener jt = new JSONTokener(fr);
    	JSONObject data=new JSONObject(jt);
    	
    	given()
		.contentType("application/json")
		.body(data.toString())
		
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


	
    
   
		
		
		
				
	
	


