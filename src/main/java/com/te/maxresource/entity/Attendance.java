package com.te.maxresource.entity;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
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
public class Attendance {
	@Id
	private int id;
	private LocalDate date;
	private LocalTime inTime;
	private LocalTime outTime;
	private int lateArrival;
	private int earlyDepature;
	
	@JoinColumn(name = "employee_id")
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Employee employee;
}
