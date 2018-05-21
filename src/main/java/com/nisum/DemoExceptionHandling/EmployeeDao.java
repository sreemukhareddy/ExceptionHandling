package com.nisum.DemoExceptionHandling;
import java.util.List;

public interface EmployeeDao {
	
	public void createEmployee(String name,String dept);
	
	public Employee getEmployee(Integer id) throws Exception;
	
	public List<Employee> getEmployees();

}