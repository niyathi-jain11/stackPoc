package com.demo.stack.dao.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.demo.stack.dao.StackDao;
import com.demo.stack.exception.ResourceNotFoundException;
import com.demo.stack.model.Employee;
import com.demo.stack.repository.StackRepository;

@Service
@Transactional
public class StackDaoImpl implements StackDao {

	@Autowired
	private StackRepository stackRepository;

	@Override
	public Employee pushEmployee(Employee employee) {
		return stackRepository.save(employee);
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		Optional<Employee> stackDb = this.stackRepository.findById(employee.getId());

		if (stackDb.isPresent()) {
			Employee stackUpdate = stackDb.get();
			stackUpdate.setId(employee.getId());
			stackUpdate.setFirstname(employee.getFirstname());
			stackUpdate.setLastname(employee.getLastname());
			stackRepository.save(stackUpdate);
			return stackUpdate;
		} else {
			throw new ResourceNotFoundException("Record not found with id : " + employee.getId());
		}
	}

	@Override
	public List<Employee> getAllEmployees() {
		return this.stackRepository.findAll();
		
	}

	@Override
	public Employee getEmployeeById(long employeeId) {
		Optional<Employee> stackDb = this.stackRepository.findById(employeeId);

		if (stackDb.isPresent()) {
			return stackDb.get();
		} else {
			throw new ResourceNotFoundException("Record not found with id : " + employeeId);
		}
	}

	@Override
	public void popEmployee() {
		Employee stackDb = this.stackRepository.findAll().get(this.stackRepository.findAll().size() - 1);

		if (stackDb != null) {
			this.stackRepository.delete(stackDb);
		} else {
			throw new ResourceNotFoundException("Stack is Empty");
		}
	}
}