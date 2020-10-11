package net.javaguides.springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import org.springframework.stereotype.Service;

import net.javaguides.springboot.model.employee;
import net.javaguides.springboot.repository.EmployeeRepository;


@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	
	@Override
	public List<employee> getAllEmployees() {
		return employeeRepository.findAll();
	}


	@Override
	public void saveEmployee(employee employee) {
		this.employeeRepository.save(employee);
		
	}


	@Override
	public employee getEmployeebyId(long id) {
	
		Optional<employee> optional = employeeRepository.findById(id);
		employee employee = null;
		if (optional.isPresent()) {
			employee = optional.get();
		}else {
			throw new RuntimeException(" Employee not found for id :: " + id);
		}
		return employee;
	}


	@Override
	public void deleteEmployeeById(long id) {
		this.employeeRepository.deleteById(id);
		
	}


	@Override
	public Page<employee> findpaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
		Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
			Sort.by(sortField).descending();
		
		
		Pageable pageable = PageRequest.of(pageNo -1, pageSize, sort);
		return this.employeeRepository.findAll(pageable);
	}

}
