package com.te.maxresource.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.te.maxresource.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, String>{

}
