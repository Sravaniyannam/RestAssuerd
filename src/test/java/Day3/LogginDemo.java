package Day3;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

import static io.restassured.matcher.RestAssuredMatchers.*;

import static org.hamcrest.Matchers.*;


public class LogginDemo {
	@Test
	void testLogs()
	{
		given()
		.when()
		  .get("https://reqres.in/api/users?page=2")
		  .then()
		  .log().all();     //it will print everything (total)
		//  .log().body();   it will print only responce body
		//log().cookies();   it will print only cookies from the responce
		//log().headers();   it will print only response from the headers
		

	}

}
