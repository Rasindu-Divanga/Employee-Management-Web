package net.javaguides.springboot.service;

import java.util.List;

import org.springframework.data.domain.Page;

import net.javaguides.springboot.model.employee;

public interface EmployeeService {
	List<employee> getAllEmployees();
	void saveEmployee(employee employee);
	
	employee getEmployeebyId(long id);
	
	void deleteEmployeeById(long id);
	
	Page<employee> findpaginated(int pageNo , int pageSize, String sortField, String sortDirection);
}
