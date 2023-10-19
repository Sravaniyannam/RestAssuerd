package Assignement3;
import static org.hamcrest.Matchers.*;

import org.hamcrest.Matcher;

import static org.hamcrest.MatcherAssert.assertThat;

 

import io.restassured.path.json.JsonPath;

public class HamcrestValidation {

	public static void main(String[] args) {
String responseBody =getResponseBody();

		

		System.out.println(JsonPath.with(responseBody).get("workspaces.name").toString());

		assertThat(JsonPath.with(responseBody).get("workspaces.name"),hasItem("workspace1"));

		assertThat(JsonPath.with(responseBody).get("workspaces.name"),hasItems("workspace1","My Workspace","Team Workspace"));

		assertThat(JsonPath.with(responseBody).get("workspaces.name"),contains("Myworkspace","Team Workspace","My Workspace","workspace1","workspace1"));     // this is same order

		assertThat(JsonPath.with(responseBody).get("workspaces.name"),containsInAnyOrder("Team Workspace","My Workspace","workspace1","workspace1","Myworkspace"));  // this is i have changed order-- i have put first-->Myworkspace is in last place

		assertThat(JsonPath.with(responseBody).get("workspaces[0]"),hasKey("name"));

 

	}

				
	

		public static String getResponseBody() {

			

 

			String responseBody = "{\r\n"

					+ "    \"workspaces\": [\r\n"

					+ "        {\r\n"

					+ "            \"id\": \"6226a33f-1c2d-463d-be60-173f639a80f7\",\r\n"

					+ "            \"name\": \"Myworkspace\",\r\n"

					+ "            \"type\": \"team\",\r\n"

					+ "            \"visibility\": \"team\"\r\n"

					+ "        },\r\n"

					+ "        {\r\n"

					+ "            \"id\": \"e09e3292-ea6d-4a03-882a-82fd97cbe349\",\r\n"

					+ "            \"name\": \"Team Workspace\",\r\n"

					+ "            \"type\": \"team\",\r\n"

					+ "            \"visibility\": \"team\"\r\n"

					+ "        },\r\n"

					+ "        {\r\n"

					+ "            \"id\": \"10b87ede-c30c-4e4e-8cde-c6962eac26db\",\r\n"

					+ "            \"name\": \"My Workspace\",\r\n"

					+ "            \"type\": \"personal\",\r\n"

					+ "            \"visibility\": \"personal\"\r\n"

					+ "        },\r\n"

					+ "        {\r\n"

					+ "            \"id\": \"41605794-4097-4ba2-8466-a6efb2dbf6bd\",\r\n"

					+ "            \"name\": \"workspace1\",\r\n"

					+ "            \"type\": \"personal\",\r\n"

					+ "            \"visibility\": \"personal\"\r\n"

					+ "        },\r\n"

					+ "        {\r\n"

					+ "            \"id\": \"6e3e31ae-91a8-42cc-b7ac-2d631b4cb97d\",\r\n"

					+ "            \"name\": \"workspace1\",\r\n"

					+ "            \"type\": \"personal\",\r\n"

					+ "            \"visibility\": \"personal\"\r\n"

					+ "        }]}";

			return responseBody;

			

		}

 

	

	}


