package com.nisum.DemoExceptionHandling;
import java.util.List;

import org.springframework.stereotype.Service;



@Service
public class EmployeeService {
  
  EmployeeDaoImpl employeeDaoImpl;
  
  
  public void setEmployeeDaoImpl(EmployeeDaoImpl employeeDaoImpl) {
	  this.employeeDaoImpl = employeeDaoImpl;
  }

  public Employee getEmployee(Integer id) throws EmployeeNotFoundException {
	  
	  Employee employee;
	  
	  try {
	  
	  employee = employeeDaoImpl.getEmployee(id);
	  
	  }
	 catch(Exception e) {
		  throw new EmployeeNotFoundException("You have entered wrong id " , id);
	  }
	  
	  return employee;
  }
  
  public List<Employee> getEmployees(){
	  
	  List<Employee> employees;
	  
	  employees=employeeDaoImpl.getEmployees();
	  return employees;
	  
  }
  
  public void createEmployee(String name,String dept) {
	  employeeDaoImpl.createEmployee(name, dept);
  }


}