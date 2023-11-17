package com.te.maxresource.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum LeaveStatus {
	PENDING("Pending"), APPROVED("Approved"), REJECTED("Rejected");

	private String status;
}
