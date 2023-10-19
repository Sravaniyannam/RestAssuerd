package Day5;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

import static io.restassured.matcher.RestAssuredMatchers.*;

import static org.hamcrest.Matchers.*;

import java.io.File;


public class FileUploadAndDownload {
	
	/*@Test
	void SingleFileUpload() {
		
		File myfile=new File("C://AutomationPratice//Test1.txt");
		given()
		   .multiPart("file",myfile)
		   .contentType("multipart/form-data")
		   
		
		.when()
		   .post("http://localhost:8080/uploabFile")
		 
		 .then()
		     .statusCode(200)
		     .body("fileName",equalTo("Test1.txt"))
		     .log().all(); */
		
	



  /*@Test
void multipleFileUpload() {
	
	File myfile1=new File("C://AutomationPratice//Test1.txt");
	File myfile2=new File("C://AutomationPratice//Test2.txt");
	given()
	   .multiPart("files",myfile1)
       .multiPart("files",myfile2)
	   .contentType("multipart/form-data")
	   
	
	.when()
	   .post("http://localhost:8080/uploabMultipleFiles")
	 
	 .then()
	     .statusCode(200)
	     .body("[0].fileName",equalTo("Test1.txt"))
	     .body("[1].fileName",equalTo("Test2.txt"))
	     .log().all(); */
	
	
	@Test
	void multipleFileUpload2() {
		
		File myfile1=new File("C://AutomationPratice//Test1.txt");
		File myfile2=new File("C://AutomationPratice//Test2.txt");
		
		File filearr[]= {myfile1,myfile2};
		given()
		   .multiPart("files",filearr)
	       
		   .contentType("multipart/form-data")
		   
		
		.when()
		   .post("http://localhost:8080/uploabMultipleFiles")
		 
		 .then()
		     .statusCode(200)
		     .body("[0].fileName",equalTo("Test1.txt"))
		     .body("[1].fileName",equalTo("Test2.txt"))
		     .log().all();
	}	
	
	
		
     @Test
     void fileDownload()
     {
    	 
    	 given()
    	 .when()
    	    .get("https://localhost:8080/downloadFile/Test1.txt")
    	    .then()
    	        .statusCode(200)
    	        .log().body();
    	  
     }
     

	
	
	
	
	

	
