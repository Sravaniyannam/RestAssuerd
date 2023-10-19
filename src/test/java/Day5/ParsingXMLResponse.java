package Day5;

import static io.restassured.RestAssured.*;

import static io.restassured.matcher.RestAssuredMatchers.*;

import static org.hamcrest.Matchers.*;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.github.scribejava.core.model.Response;

import io.restassured.path.xml.XmlPath;



public class ParsingXMLResponse {
	
/*	@Test
	
	
	void testXMLResponse()
	{
		//Approach
		given()
		
		.when()
		  .get("http://restapi.adequateshop.com/api/Traveler?page=1")
		.then()
		   .statusCode(200)
		   .header("Content-Type,"application/xml; charset=utf-8")
		   .body("TravelerinformationResponse.page",equalTo("1"))
		   .boby("TravelerinformationResponse.travelers.Travelerinformation[0].name",equalTo("Developer"));
		  */ 
		
		//Approach2  validations on the json response by using xmlpath
		
	/*	Response res=
		given()
		  
		.when()
		    .get("http://restapi.adequateshop.com/api/Traveler?page=1");
		    
		   Assert.assertEquals(res.getStatusCode(), 200);
	      Assert.assertEquals(res.header("Content-Type"),"application/xml; charset=utf-8"); 
	      String pageNo=res.xmlPath().get("TravelerinformationResponse.page").toString();
	      Assert.assertEquals(pageNo, "1");
	      
	      String travelName=res.xmlpath().get("TravelerinformationResponse.travelers.Travelerinformation[0].name").toString();
	      Assert.assertEquals(travelName,"Developer");*/
	      
	      
		@Test
	     void testXMLResponseBody()
		 
		 {
			Response res=
					(Response) given()
			
			.when()
			    .get("http://restapi.adequateshop.com/api/Traveler?page=1");
			    XmlPath xmlobj=new XmlPath(res.toString());
			    
			    //verify total number of travelers
			List<String>travellers=xmlobj.getList("TravelerinforamtionResponse.travelers.Travelerinforamtion");
			Assert.assertEquals(travellers.size(), 10);    
			
			//verify traveler name is present in response
			List<String>traveller_names=xmlobj.getList("TravelerinforamtionResponse.travelers.Travelerinforamtion.name");
			
			boolean status=false;
			for(String travellername:traveller_names)
			{
				if(travellername.equals("Developer"))
				{
					status=true;
					break;
				}
			}
			Assert.assertEquals(status, true);
			
			
					
			
		 }
		 
	}


