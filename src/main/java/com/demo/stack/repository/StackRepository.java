package com.demo.stack.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.stack.model.Employee;

public interface StackRepository extends JpaRepository<Employee, Long> {

}