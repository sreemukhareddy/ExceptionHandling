package com.nisum.testscripts2;

import java.util.List;

import org.json.simple.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;


public class MainTestToolsQA {
	
	
	// read all the employees and show the response body as a string
	/*@Test
	public void testGetAllEmployees() {
		RestAssured.baseURI = "http://localhost:8080/DemoExceptionHandling/webapi/Employee";
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.request(Method.GET, "/readAllEmployees");
		String responseBody = response.getBody().asString();
		System.out.println("Response Body is =>  " + responseBody);
	}*/
	
	// read all the employees and check the status code
	/*@Test
	public void testForStatusForGetAllEmployees() {
		RestAssured.baseURI = "http://localhost:8080/DemoExceptionHandling/webapi/Employee";
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.request(Method.GET, "/readAllEmployees");
		int status = response.getStatusCode();
		//Assert.assertEquals(300, status);// for fail
		Assert.assertEquals("QWERTY", 200, status);// for pass
		
	}*/
	
	// read all the employees and show the output in json format
	/*@Test
	public void testForJsonFormatOnGetAllEmployees() {
		RestAssured.baseURI = "http://localhost:8080/DemoExceptionHandling/webapi/Employee";
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.request(Method.GET, "/readAllEmployees");
		ResponseBody responseBody=response.getBody();
		System.out.println(responseBody.asString());
	}*/
	
	// read all the employees , show the output in the json format , check whether the string contains a particular token 
	/*@Test
	public void testForSpecificFieldOnGetAllEmployees() {
		RestAssured.baseURI = "http://localhost:8080/DemoExceptionHandling/webapi/Employee";
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.request(Method.GET, "/readAllEmployees");
		ResponseBody responseBody=response.getBody();
		String field=responseBody.asString();
		System.out.println(field);
		Assert.assertEquals("QWERTY", false, field.toLowerCase().contains("dept"));
	}*/
	
	// use json path evaluator
	/*@Test
	public void testForJsonPathEvaluator() {
		RestAssured.baseURI = "http://localhost:8080/DemoExceptionHandling/webapi/Employee";
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.request(Method.GET, "/readAllEmployees");
		JsonPath jsonPath=response.jsonPath();
		List<String> depts = jsonPath.get("dept");
		System.out.println(depts);
	}*/
	
	// using json to post the content
	@Test
	public void testForPostWithJsonOncreateEmployee() {
		RestAssured.baseURI = "http://localhost:8080/DemoExceptionHandling/webapi/Employee";
		RequestSpecification httpRequest = RestAssured.given();
		JSONObject requestParams = new JSONObject();
		requestParams.put("dept", "Virender"); // Cast
		requestParams.put("name", "Singh");
		Response response = httpRequest.post("/createEmployee");
		int statusCode = response.getStatusCode();
		System.out.println(statusCode);
		Assert.assertEquals(statusCode, 201);
	}

}
