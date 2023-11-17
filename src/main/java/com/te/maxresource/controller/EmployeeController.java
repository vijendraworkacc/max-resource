package com.te.maxresource.controller;

import static com.te.maxresource.constents.EmployeeConstents.ALL_THE_EMPLOYEES_DATA_PROVIDED;
import static com.te.maxresource.constents.EmployeeConstents.EMPLOYEE_DATA_PROVIDED;
import static com.te.maxresource.constents.EmployeeConstents.EMPLOYEE_DELETED;
import static com.te.maxresource.constents.EmployeeConstents.EMPLOYEE_SAVED;

import java.time.LocalDateTime;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.te.maxresource.dto.EmployeeDTO;
import com.te.maxresource.response.SuccessResponse;
import com.te.maxresource.service.EmployeeService;

@RequestMapping(path = "api/v1/employees")
@RestController
public record EmployeeController(EmployeeService employeeService) {

	@GetMapping(path = "")
	public ResponseEntity<SuccessResponse> getEmployees() {
		return ResponseEntity
				.<SuccessResponse>ofNullable(SuccessResponse.builder().message(ALL_THE_EMPLOYEES_DATA_PROVIDED)
						.timestamp(LocalDateTime.now()).data(employeeService.getEmployees()).build());
	}

	@GetMapping(path = "/{id}")
	public ResponseEntity<SuccessResponse> getEmployee(@PathVariable("id") String id) {
		return ResponseEntity.<SuccessResponse>ofNullable(SuccessResponse.builder().message(EMPLOYEE_DATA_PROVIDED)
				.timestamp(LocalDateTime.now()).data(employeeService.getEmployee(id)).build());
	}

	@PostMapping(path = "")
	public ResponseEntity<SuccessResponse> addEmployee(@RequestBody EmployeeDTO employeeDTO) {
		return ResponseEntity.<SuccessResponse>ofNullable(SuccessResponse.builder().message(EMPLOYEE_SAVED)
				.timestamp(LocalDateTime.now()).data(employeeService.addEmployee(employeeDTO)).build());
	}

	@PutMapping(path = "/{id}")
	public ResponseEntity<SuccessResponse> updateEmployee(@PathVariable("id") String id,
			@RequestBody EmployeeDTO employeeDTO) {
		return ResponseEntity.<SuccessResponse>ofNullable(SuccessResponse.builder().message(EMPLOYEE_SAVED)
				.timestamp(LocalDateTime.now()).data(employeeService.updateEmployee(id, employeeDTO)).build());
	}

	@DeleteMapping(path = "/{id}")
	public ResponseEntity<SuccessResponse> deleteEmployee(@PathVariable("id") String id) {
		return ResponseEntity.<SuccessResponse>ofNullable(SuccessResponse.builder().message(EMPLOYEE_DELETED)
				.timestamp(LocalDateTime.now()).data(employeeService.deleteEmployee(id)).build());
	}

}
