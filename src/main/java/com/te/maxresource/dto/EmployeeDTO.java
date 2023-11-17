package com.te.maxresource.dto;

import java.time.LocalDate;

import lombok.Builder;

@Builder
public record EmployeeDTO(
		String firstName, 
		String lastName, 
		String email, 
		String contactNumber, 
		LocalDate joiningDate,
		String department, 
		String designation) {

}
