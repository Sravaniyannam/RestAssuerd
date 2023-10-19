package pratice;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

import static io.restassured.matcher.RestAssuredMatchers.*;

import static org.hamcrest.Matchers.*;

public class RequestspecificationExample {
	
	@Test
	public void valid_status_code() {
		given()
		.baseUri("https://api.postman.com")
		.heade()
		
	}

}
