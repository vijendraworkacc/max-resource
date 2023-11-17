package com.te.maxresource.entity;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity
public class Employee {
	@Id
	private String id;
	private String firstName;
	private String lastName;
	private String email;
	private String contactNumber;
	private LocalDate joiningDate;
	private String department;
	private String designation;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "employee")
	private List<LeaveRequest> leaveRequests;
	
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private PerformanceReview performanceReview;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "employee")
	private List<Attendance> attendance;
}
