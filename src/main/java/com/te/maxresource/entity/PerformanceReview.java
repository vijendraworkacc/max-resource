package com.te.maxresource.entity;

import java.time.LocalDate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
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
public class PerformanceReview {
	@Id
	private int id;
	private LocalDate reviewDate;
	private String reviewerName;
	private String reviewerComment;
	private int reviewerRating;
	
	@OneToOne(
			fetch = FetchType.LAZY, 
			cascade = CascadeType.ALL, 
			mappedBy = "performanceReview"
	)
	private Employee employee;
}
