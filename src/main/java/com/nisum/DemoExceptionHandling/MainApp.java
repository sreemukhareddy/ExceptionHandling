package com.nisum.DemoExceptionHandling;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.log4j.Appender;
import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.Layout;
import org.apache.log4j.Logger;
import org.apache.log4j.SimpleLayout;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.EmptyResultDataAccessException;

@Path("Employee")
public class MainApp {
	
	static Logger log = Logger.getLogger(MainApp.class.getName());
	 Layout l1 = new SimpleLayout();
	   Appender a = new ConsoleAppender(l1);
	
	 ApplicationContext context = new ClassPathXmlApplicationContext("dataAccess.xml");
	 EmployeeService employeeService=context.getBean("employeeService",EmployeeService.class);
	 
	 
	 @GET
     @Path("readAllEmployees")
     @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	 public List<Employee> getEmployees(){
		 
		 List<Employee> employees = null;
		 
		 
			 employees=employeeService.getEmployees();
		return employees;
		 
	 }
	 
	 @GET
	 @Path("readAnEmployee/{id}")
	 @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	 public Response getResultByPassingValue(@PathParam("id") Integer id)  {
		 Employee e=null;
	
			try {
				e=employeeService.getEmployee(id);
				if(e!=null)
				{
					return Response.status(200).entity(e).build();
				}
				else
				{
					return Response.status(600).entity("No data found for this id " + id).build();
				}
			} catch (EmployeeNotFoundException e1) {
				 log.fatal("This is the error message..");
				 System.out.println(e1);	
			} 
		
		 return null;
	 }
	 
	 @POST
	 @Path("createEmployee")
	 @Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	 @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	 public Response createEmployee(Employee employee) {
		 employeeService.createEmployee(employee.getName(), employee.getDept());
		 return Response.status(201).entity("SUCCESS").build();
	 }

}