package com.nisum.DemoExceptionHandling;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;


public class EmployeeDaoImpl implements EmployeeDao{
	
	    DataSource dataSource;
	    JdbcTemplate jdbcTemplate;
	 
	   
	   public void setDataSource(DataSource dataSource) {
		      this.dataSource = dataSource;
		      this.jdbcTemplate = new JdbcTemplate(dataSource);
		   }

	@Override
	public Employee getEmployee(Integer id) throws Exception  {
		
		  String SQL = "select * from employee where id = ?";
		  Employee employee = null;
		  try {
		  employee = jdbcTemplate.queryForObject(SQL,new Object[]{id}, new EmployeeMapper());
		  }
		  catch(DataAccessException dae) {
			  //throw new EmployeeNotFoundException("You have entered wrong id " ,id);
		  }
		  catch(Exception e) {
			  throw e;
		  }
		 
	      return employee;
	}

	@Override
	public List<Employee> getEmployees() {
		  String SQL = "select * from employee";
	      List <Employee> employees = jdbcTemplate.query(SQL, new EmployeeMapper());
	      return employees;
	}

	@Override
	public void createEmployee(String name, String dept) {
		String SQL = "insert into employee (name, dept) values (?, ?)";
	     jdbcTemplate.update(SQL,name,dept);
	     // System.out.println("Created Record Name = " + name + " Age = " + age);
		
	}

}