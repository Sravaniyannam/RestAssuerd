package Assignement2;
import org.testng.annotations.BeforeClass;

import org.testng.annotations.Test;

 

import io.restassured.RestAssured;

import io.restassured.builder.RequestSpecBuilder;

import io.restassured.builder.ResponseSpecBuilder;

import io.restassured.filter.log.LogDetail;

import io.restassured.http.ContentType;

 

import static org.hamcrest.Matchers.equalTo;

 

import static io.restassured.RestAssured.*;

import static io.restassured.matcher.RestAssuredMatchers.*;

import static org.hamcrest.Matchers.*;

public class AutomatePost {
	@BeforeClass

	void beforeClass() {

		

		RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder()

				.setBaseUri("https://2ca9f0e7-0003-4ea8-9e34-64def23fcf55.mock.pstmn.io")

				.addHeader("Content-Type", "text/html; charset=utf-8")

				.setContentType(ContentType.JSON)

			    .log(LogDetail.ALL);

		RestAssured.requestSpecification =requestSpecBuilder.build();

		

		ResponseSpecBuilder responseSpecBuilder =new ResponseSpecBuilder()

				.expectStatusCode(201)

				.expectContentType(ContentType.JSON)

				.log(LogDetail.ALL);

		RestAssured.responseSpecification =responseSpecBuilder.build();	

		

	}

		@Test

	    void test_post_request_bdd_style() {

			

			String payload = "{\r\n"

					+ "    \"name\": \"John\",\r\n"

					+ "    \"age\": 30,\r\n"

					+ "    \"cars\": [\r\n"

					+ "        \"Ford\",\r\n"

					+ "        \"BMW\",\r\n"

					+ "        \"Fiat\"\r\n"

					+ "    ]\r\n"

					+ "}";

   

		given()

		  .body(payload)	

		

		.when()

		   .post("/Test")

		

		 .then()

		   .assertThat()

		   .body("name", equalTo("John"));		

		

		System.out.println("Request Headers: " +requestSpecification.log().headers());

		System.out.println("Response Headers:" + responseSpecification.log().headers());

		System.out.println("Request Body: " + payload);

	//	System.out.println("Response Body: " + responseBody);

		

		

	}

 

}


