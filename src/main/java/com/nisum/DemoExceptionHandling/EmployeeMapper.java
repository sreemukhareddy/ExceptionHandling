package com.nisum.DemoExceptionHandling;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class EmployeeMapper implements RowMapper<Employee> {

	@Override
	public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Employee employee = new Employee();
		employee.setName(rs.getString("name"));
		employee.setDept(rs.getString("dept"));
		employee.setId(rs.getInt("id"));
		
		return employee;
	}

}
