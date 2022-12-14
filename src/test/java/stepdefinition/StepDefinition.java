package stepdefinition;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.runner.RunWith;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import resources.TestDataResources;
import resources.Utilities;


@RunWith(Cucumber.class)
public class StepDefinition extends Utilities{
	RequestSpecification req1;
	ResponseSpecification res1;
	Response res;
	TestDataResources tdr = new TestDataResources();
	
	@Given("Add place payload {string} {string} {string}")
	public void add_place_payload(String name, String language, String address) throws IOException {
		
		req1 = given().spec(requestSpec()).body(tdr.addPlaceApyload(name, language, address));
	}

	@When("user calls {string} using Post HTTP Request")
	public void user_calls_using_post_http_request(String string) {
		res1 = new ResponseSpecBuilder().build();
        res = req1.when().post("maps/api/place/add/json").then().spec(res1).extract().response();
		String resString = res.asString();
		System.out.println(resString);
	    
	}

	@Then("API call got success with status code {int}")
	public void api_call_got_success_with_status_code(Integer int1) {
	    
	    assertEquals(res.getStatusCode(), 200);
	    System.out.println("jhdjdbjkasbdksdk");
	}

	@And("^status in response body is OK$")
	public void status_in_response_body_is_ok() {
	    
	}

@Then("{string} in response body is {string}")
public void in_response_body_is(String key, String value) {
	String s = res.asString();
	JsonPath js = new JsonPath(s);
	key = js.get(key);
	//value = "OK";
	//assertEquals(key , value);
	assertEquals(key , value);
	
   
}




}
