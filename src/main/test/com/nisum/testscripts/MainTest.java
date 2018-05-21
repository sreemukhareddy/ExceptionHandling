package com.nisum.testscripts;

import  static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

public class MainTest {
	
	@Test
	public void validateGetAllEmployees() {
		given().get("http://localhost:8080/DemoExceptionHandling/webapi/Employee/readAllEmployees").then().statusCode(200).log().all();
	}

}
