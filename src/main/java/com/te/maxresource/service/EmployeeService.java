package com.te.maxresource.service;

import static com.te.maxresource.constents.EmployeeConstents.EMPLOYEE_WITH_THE_PROVIDED_EMPLOYEE_ID_WAS_NOT_FOUND;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.te.maxresource.dto.EmployeeDTO;
import com.te.maxresource.entity.Employee;
import com.te.maxresource.entity.EmployeeIDGenerator;
import com.te.maxresource.exception.EmployeeNotFoundExcetion;
import com.te.maxresource.repository.EmployeeRepository;

@Service
public record EmployeeService(EmployeeRepository employeeRepository) {

	public List<EmployeeDTO> getEmployees() {
		return employeeRepository.findAll().stream()
				.map(e -> EmployeeDTO.builder().firstName(e.getFirstName()).lastName(e.getLastName())
						.email(e.getEmail()).contactNumber(e.getContactNumber()).joiningDate(e.getJoiningDate())
						.department(e.getDepartment()).designation(e.getDesignation()).build())
				.collect(Collectors.toList());
	}

	public EmployeeDTO getEmployee(String id) {
		Employee e = employeeRepository.findById(id)
				.orElseThrow(() -> new EmployeeNotFoundExcetion(EMPLOYEE_WITH_THE_PROVIDED_EMPLOYEE_ID_WAS_NOT_FOUND));
		return EmployeeDTO.builder().firstName(e.getFirstName()).lastName(e.getLastName()).email(e.getEmail())
				.contactNumber(e.getContactNumber()).joiningDate(e.getJoiningDate()).department(e.getDepartment())
				.designation(e.getDesignation()).build();
	}

	public String addEmployee(EmployeeDTO dto) {
		return employeeRepository.save(Employee.builder().id(EmployeeIDGenerator.getGeneratedEmployeeID())
				.firstName(dto.firstName()).lastName(dto.lastName()).email(dto.email())
				.contactNumber(dto.contactNumber()).joiningDate(dto.joiningDate()).department(dto.department())
				.designation(dto.designation()).build()).getId();
	}

	public String updateEmployee(String id, EmployeeDTO dto) {
		Employee e = employeeRepository.findById(id)
				.orElseThrow(() -> new EmployeeNotFoundExcetion(EMPLOYEE_WITH_THE_PROVIDED_EMPLOYEE_ID_WAS_NOT_FOUND));
		e.setLastName(dto.lastName());
		e.setEmail(dto.email());
		e.setContactNumber(dto.contactNumber());
		e.setJoiningDate(dto.joiningDate());
		e.setDepartment(dto.department());
		e.setDesignation(dto.designation());
		return employeeRepository.save(e).getId();
	}

	public String deleteEmployee(String id) {
		employeeRepository.delete(employeeRepository.findById(id)
				.orElseThrow(() -> new EmployeeNotFoundExcetion(EMPLOYEE_WITH_THE_PROVIDED_EMPLOYEE_ID_WAS_NOT_FOUND)));
		return id + " deleted";
	}

}
