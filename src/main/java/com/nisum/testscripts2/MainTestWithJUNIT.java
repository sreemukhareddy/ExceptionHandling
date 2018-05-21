package com.nisum.testscripts2;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalToIgnoringCase;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.nisum.DemoExceptionHandling.Employee;

import io.restassured.http.ContentType;
import io.restassured.response.Response;


public class MainTestWithJUNIT extends BaseClass {

	
	/*@Test
	public void validateGetAllEmployees() throws URISyntaxException {
		
		//when().get("http://localhost:8080/DemoExceptionHandling/webapi/Employee/readAllEmployees").then().statusCode(200).log().all();
		Response response = given()
		.accept(ContentType.JSON)
		.when()
		.get("http://localhost:8080/DemoExceptionHandling/webapi/Employee/readAllEmployees");
		
		System.out.println(response.asString());
		
	}*/
	
	/*@Test
	public void validateGetAnEmployee()  {
	
		Response response = given()
				.accept(ContentType.JSON)
				.when()
				.get("http://localhost:8080/DemoExceptionHandling/webapi/Employee/readAnEmployee/2");
				
				System.out.println(response.asString());	
	}*/
	
	/*@Test
	public void testStatusCode() {
	int i=	given()
		.accept(ContentType.JSON)
		.when()
		.get("http://localhost:8080/DemoExceptionHandling/webapi/Employee/readAnEmployee/3") // failing the case and catching the status code
		.thenReturn()
		.statusCode();
	
	System.out.println(i);
	
	Assert.assertEquals(HttpStatus.SC_ACCEPTED, i);
		
		
		given()
		.accept(ContentType.JSON)
		.when()
		.get("/readAnEmployee/1") // failing the case and catching the status code
		.then()
		.assertThat()
		.statusCode(400);
		
		
	}
	*/
	
	/*@Test
	public void testContent() {
		given()
		.accept(ContentType.JSON)
		.when()
		.get("/readAnEmployee/2") // failing the case and catching the status code
		.then()
		.body("name",equalToIgnoringCase("girish"));
		
	}*/
	
	/*@Test
	public void storeEmployee() {
		Response response=given()
		.accept(ContentType.JSON)
		.param("name", "cricket")
		.param("dept", "sehwag")
		.when()
		.post("/createEmployee")
		.then()
		.assertThat()
		.statusCode(201);
		
		
		
		
	}*/
	
	@Test
	public void storeEmployee() {
		
		Employee e=new Employee();
		e.setName("test1");
		e.setDept("test2");	
		given()
		.contentType("application/json")
		.body(e)
		.when()
		.post("/createEmployee")
		.then()
		.statusCode(201);		
	}

}
