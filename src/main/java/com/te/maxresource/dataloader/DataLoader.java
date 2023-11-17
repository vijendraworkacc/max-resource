package com.te.maxresource.dataloader;

import java.time.LocalDate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.te.maxresource.entity.Employee;
import com.te.maxresource.entity.EmployeeIDGenerator;
import com.te.maxresource.repository.EmployeeRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class DataLoader implements CommandLineRunner {
	
	private final EmployeeRepository employeeRepository;

	@Override
	public void run(String... args) throws Exception {
		if (employeeRepository.count() < 1) {
			employeeRepository.save(Employee.builder()
					.id(EmployeeIDGenerator.getGeneratedEmployeeID())
					.firstName("FN1")
					.lastName("LN1")
					.email("e@e.com")
					.contactNumber("9090909090")
					.joiningDate(LocalDate.now())
					.department("Dev")
					.designation("Software Engineer")
					.build());
			
			employeeRepository.save(Employee.builder()
					.id(EmployeeIDGenerator.getGeneratedEmployeeID())
					.firstName("FN2")
					.lastName("LN2")
					.email("e2@e.com")
					.contactNumber("9190909090")
					.joiningDate(LocalDate.now())
					.department("Dev")
					.designation("Software Engineer")
					.build());
		}
	}

}
