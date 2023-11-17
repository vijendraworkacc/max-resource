package com.te.maxresource.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
enum LeaveType {
	SICK_LEAVE("Sick leave"), PERSONAL_LEAVE("Personal leave");

	private String type;
}
