package restAssured;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class TestAPI {
	
	@Test
	public void GetWeatherDetails()
	{   
		RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
		RequestSpecification httpRequest = RestAssured.given();

		Response response = httpRequest.request(Method.GET, "/Chennai");
		
		String responseBody = response.getBody().asString();
		System.out.println("Response Body is =>  " + responseBody);
		Assert.assertTrue(response.getBody().asString().contains("Chennai"));
		
		int Response = response.statusCode();
		System.out.println("Response Code is =>  " + Response);
	}
	
	@Test
	public void getdetails() {
		RestAssured.baseURI =	"https://www.toolsqa.com/rest-assured";
		RequestSpecification httpRequest = RestAssured.given();
		
//		Response response = httpRequest.request(Method.GET, "/post-request-using-rest-assured");
		Response response = httpRequest.get();
		String responseBody = response.getBody().asString();
		System.out.println("Response Body is =>  " + responseBody);
		
	}

}
