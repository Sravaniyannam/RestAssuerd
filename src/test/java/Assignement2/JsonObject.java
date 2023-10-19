package Assignement2;
import static io.restassured.RestAssured.given;

import static org.hamcrest.Matchers.equalTo;

 

import org.json.JSONObject;

import org.testng.annotations.Test;

 

import static io.restassured.RestAssured.*;

import static io.restassured.matcher.RestAssuredMatchers.*;

import static org.hamcrest.Matchers.*;

 

public class JsonObject {
	
	@Test(priority =1)

	void testpostusingJsonLibrary()

	{

		

		JSONObject data = new JSONObject();        // we have created json object variable  and also we have to add dependency in pom.xml we have already added

		

		data.put("name", "John");

		data.put("age", "30");

		

		

		String cars[] = {"Ford","BMW","Fiat"};

		data.put("cars",cars);

		

		

		given()

		 .contentType("application/json")

		 .body(data.toString())                               // we are using org.json so we have to convert the data into string format -- using toString()

		

		.when()

		  .post("https://be460055-9c41-4647-be50-78ebf92350c7.mock.pstmn.io/Test")     // this path came from once we executing in the command promt(cmd) using json-server students.json -- after executing the cmd dont close it just minimize it.

		  

		.then()                                    // verifying the data

		  .statusCode(404)


		  .body("age", equalTo(30))

		  .body("cars[2]", equalTo("Fiat"))

		  .body("cars[0]", equalTo("Ford"))

		  .body("cars[1]", equalTo("BMW"))

		  .header("Content-Type","application/json; charset=utf-8")

		 . statusLine("HTTP/1.1 201 Created")

		  .log().all();

	}
}
