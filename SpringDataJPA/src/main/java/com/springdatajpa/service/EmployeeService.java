package com.springdatajpa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.springdatajpa.dao.EmployeeRepository;
import com.springdatajpa.model.Employee;

@Service
public class EmployeeService {

	private final EmployeeRepository employeeRepository;
	public EmployeeService(EmployeeRepository employeeRepository)
	{
		this.employeeRepository = employeeRepository;
	}
	
	public List<Employee> saveEmployee(List<Employee> emp) 
	{
		return employeeRepository.saveAll(emp); //saveAll():Saves Multiple Employees into Database
	}

	public Optional<Employee> getEmployee(int eid) 
	{
		Optional<Employee> id = employeeRepository.findById(eid);
		return id;
	}

	public List<Employee> getAllEmployees() 
	{
		List<Employee> allEmployees = employeeRepository.findAll();
		return allEmployees;
	}
	
	
	public Optional<Employee> updateSalary(float salary,int eid)
	{
		 employeeRepository.updateEmployeeSalary(salary, eid);
		 
		 return employeeRepository.findById(eid);
	}
	
	public Optional<Employee> updateEmployeeName(String name,int eid)
	{
		employeeRepository.updateEmployeeName(name, eid);
		
		return employeeRepository.findById(eid);
	}
	
	public List<Employee> getAllEmployeesDetails()
	{
		return employeeRepository.findAll();
	}
	
	public List<Employee> getEmployeeByName(String name)
	{
		return employeeRepository.findByName(name);
	}
	
	public List<Employee> getEmployeeByNameAndSalary(String name,float salary)
	{
		return employeeRepository.findByNameAndSalary(name, salary);
	}
	
	public List<Employee> getEmployeeByNameOrDept(String name,String dept)
	{
		return employeeRepository.findByNameOrDept(name, dept);
	}
	
	public List<Employee> getEmployeeNameStartingWith(String name)
	{
		return employeeRepository.findByNameStartingWith(name);
	}
	
	public List<Employee> getEmployeeNameEndingWith(String name)
	{
		return employeeRepository.findByNameEndingWith(name);
	}
	
	public List<Employee> getEmployeeNameContains(String name)
	{
		return employeeRepository.findByNameContains(name);

	}
	
	//PagingAndSorting
	public Page<Employee> getEmployeeDetailsByPage(int pageNumber,int size)
	{
		Sort sort = Sort.by(Employee::getSalary).ascending();
		PageRequest pageRequest = PageRequest.of(pageNumber, size,sort);
		return employeeRepository.findAll(pageRequest);
	}
	
	
	public int deleteEmployeeById(int eid)
	{
		return employeeRepository.deleteEmployeeById(eid);
		
		
	}
}
