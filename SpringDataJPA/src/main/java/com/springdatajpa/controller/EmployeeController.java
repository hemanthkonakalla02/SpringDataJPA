package com.springdatajpa.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springdatajpa.model.Employee;
import com.springdatajpa.service.EmployeeService;

@RestController
@RequestMapping("/api/Employee")
public class EmployeeController  //Controller : Handles Request and Response
{

	private final EmployeeService employeeService;
	public EmployeeController(EmployeeService employeeService)
	{
		this.employeeService = employeeService;
		
	}
	
	//CREATE
	@PostMapping("/saveEmployee")
	public List<Employee> createEmployee(@RequestBody List<Employee> emp)
	{
		return employeeService.saveEmployee(emp);
	}
	
	//READ
	@GetMapping("/getEmployeeBasedOnId")
	public Optional<Employee> getEmployeeDetails(@RequestParam(name = "eid") int eid)
	{
		return employeeService.getEmployee(eid);
	}
	
	//READALL
	@GetMapping("/getAllEmployees")
	public List<Employee> getAllEmployeeDetails()
	{
		return employeeService.getAllEmployees();
	}
	
	//UPDATE with JPQL
	@PostMapping("/updateEmployee")
	public Optional<Employee> updateEmployeeSalaries(@RequestParam(name="salary") float salary,@RequestParam(name="eid") int eid)
	{
		return employeeService.updateSalary(salary,eid);
	}
	
	//UPDATE with NativeQuery
	@PutMapping("/updateEmployeeName")
	public Optional<Employee> updateEmployeeDetails(@RequestParam(name="name") String name,@RequestParam(name="eid") int eid)
	{
		return employeeService.updateEmployeeName(name, eid);
	}
	
	//Native Query
	@GetMapping("/allEmployees")
	public List<Employee> fetchAllEmployess()
	{
		return employeeService.getAllEmployees();
	}
	
	@GetMapping("/getByName")
	public List<Employee> fetchEmployeeByName(@RequestParam(name = "name") String name)
	{
		return employeeService.getEmployeeByName(name);
	}
	
	@GetMapping("/getByNameAndSalary")
	public List<Employee> fetchEmployeeByNameAndSalary(@RequestParam(name="name")String name,@RequestParam(name="salary") float salary)
	{
		return employeeService.getEmployeeByNameAndSalary(name,salary);
	}
	
	
	@GetMapping("/getByNameOrDept")
	public List<Employee> fetchEmployeeByNameOrDept(@RequestParam(name="name") String name,
			@RequestParam(name="dept") String dept)
	{
		
		return employeeService.getEmployeeByNameOrDept(name, dept);
	}
	
	
	@GetMapping("/getByNameStartingWith")
	public List<Employee> fetchEmployeeNameStartingWith(@RequestParam(name="name")String name)
	{
		return employeeService.getEmployeeNameStartingWith(name);
	}
	
	
	@GetMapping("/getByNameEndingWith")
	public List<Employee> fetchEmployeeNameEndingWith(@RequestParam(name="name") String name)
	{
		return employeeService.getEmployeeNameEndingWith(name);
	}
	
	@GetMapping("/getByNameContains")
	public List<Employee> fetchEmployeeNameContains(@RequestParam(name="name") String name)
	{
		return employeeService.getEmployeeNameContains(name);
	}
	
	
	@DeleteMapping("/deleteById")
	public int deleteById(@RequestParam(name="eid") int eid)
	{
		return employeeService.deleteEmployeeById(eid);
	}
	
	@GetMapping("/getEmployeeDetailsPageWise")
	public Page<Employee> fetchEmployeeDetailsPageWise(@RequestParam(name="pageNumber") int pageNumber,
			@RequestParam(name="size") int size)

	{
		return employeeService.getEmployeeDetailsByPage(pageNumber, size);
	}
	

}
