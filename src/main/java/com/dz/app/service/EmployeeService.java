package com.dz.app.service;

import java.util.List;

import com.dz.app.dto.EmployeeDto;
import com.dz.app.model.entity.Employee;

public interface EmployeeService {


	Employee saveEmployee(EmployeeDto dto);
	Employee findById(long eid);
	Employee updateEmployee(Employee empTrn);
	void deleteEmployee(Employee empTrn);
	List<Employee> getAllEmployees();
	List<Employee> getAllEmployeesForPagination(Integer pageSize, Integer currentPage, String sortBy);
	void deleteAll();
	Long totalEmployeeCount();
	
}
