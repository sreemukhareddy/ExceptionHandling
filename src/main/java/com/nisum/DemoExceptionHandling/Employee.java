package com.nisum.DemoExceptionHandling;

//@XmlRootElement
public class Employee {
  
	
  private Integer id;
  private String name;
  private String dept;

  
  public Employee(Integer id, String name, String dept) {
	this.id=id;
	this.name=name;
	this.dept=dept;
}
  
  
  
  
public Employee(Integer id, String name) {
	//super();
	this.id = id;
	this.name = name;
}




public Employee() {
	
}




public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getDept() {
	return dept;
}
public void setDept(String dept) {
	this.dept = dept;
}
    
  
}