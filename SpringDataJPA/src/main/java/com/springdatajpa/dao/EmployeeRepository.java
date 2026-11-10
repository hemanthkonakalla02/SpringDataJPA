package com.springdatajpa.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.springdatajpa.model.Employee;

import jakarta.transaction.Transactional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> 
{
	//JPQL : Jakarta Persistence Query Langauge
	@Modifying
	@Transactional
	@Query("update  Employee  set salary=:salary where eid=:eid")
	int updateEmployeeSalary(@Param("salary") float salary,@Param("eid") int eid);
	
	//Nativequery
	@Modifying
	@Transactional
	@Query(value="update employees set name=:name where eid=:eid",nativeQuery = true)
	int updateEmployeeName(@Param("name")String name,@Param("eid") int eid);
	
	@Query("SELECT e from Employee e")
	List<Employee> getAllEmployeeDetails();
	
	
	@Modifying
	@Transactional
	@Query("delete Employee where eid=:eid")
	int deleteEmployeeById(@Param("eid") int eid);
	
	//finder Methods
	List<Employee> findByName(String name);
	
	List<Employee> findByNameAndSalary(String name,float salary);
	
	List<Employee> findByNameOrDept(String name,String dept);
	
	List<Employee> findByNameStartingWith(String name);
	
	
	List<Employee> findByNameEndingWith(String name);
	
	
	List<Employee> findByNameContains(String name);
	
	
	
}
