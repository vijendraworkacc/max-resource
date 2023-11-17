package com.te.maxresource.entity;

import java.time.LocalDate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
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
public class LeaveRequest {
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private int id;
	private LocalDate startDate;
	private LocalDate endDate;
	private String reason;
	
	@Enumerated(EnumType.STRING)
	private LeaveType leaveType;
	
	@Enumerated(EnumType.STRING)
	private LeaveStatus leaveStatus;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Employee employee;
}
