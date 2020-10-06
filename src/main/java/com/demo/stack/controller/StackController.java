package com.demo.stack.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.demo.stack.dao.StackDao;
import com.demo.stack.model.Employee;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(tags = {
		"employee" }, produces = "application/json", consumes = "application/json", description = "Operations related to Employee")
@RequestMapping("/employee")
public class StackController {

	@Autowired
	private StackDao stackService;

	@ApiOperation(value = "Saves Employee object.", nickname = "createEmployee", notes = "Saves Employee object to db store.", response = Employee.class, tags = {})
	@RequestMapping(produces = { "application/json" }, consumes = { "application/json" }, method = RequestMethod.POST)
	public ResponseEntity<Employee> pushEmployee(@RequestBody Employee employee) {
		return ResponseEntity.ok().body(this.stackService.pushEmployee(employee));
	}

	@ApiOperation(value = "Removes Employee object.", nickname = "removeEmployee", notes = "Removes existing Employee in db store.", response = Employee.class, tags = {})
	@RequestMapping(method = RequestMethod.DELETE)
	public HttpStatus popEmployee() {
		this.stackService.popEmployee();
		return HttpStatus.OK;
	}

	@ApiOperation(value = "Updates Employee object.", nickname = "updateEmployee", notes = "Updates existing Employee in db store.", response = Employee.class, tags = {})
	@RequestMapping(value = "/{id}", produces = { "application/json" }, consumes = {
			"application/json" }, method = RequestMethod.PUT)
	public ResponseEntity<Employee> updateEmployee(@PathVariable long id, @RequestBody Employee employee) {
		employee.setId(id);
		return ResponseEntity.ok().body(this.stackService.updateEmployee(employee));
	}

	@ApiOperation(value = "Returns list of Employees.", nickname = "getAllEmployees", notes = "Returns list of all available Employees.", response = Employee.class, tags = {})
	@RequestMapping(produces = { "application/json" }, method = RequestMethod.GET)
	public ResponseEntity<List<Employee>> getAllEmployees() {
		return ResponseEntity.ok().body(stackService.getAllEmployees());
	}

	@ApiOperation(value = "Returns Employee object.", nickname = "getEmployee", notes = "Returns Employee object.", response = Employee.class, tags = {})
	@RequestMapping(value = "/{id}", produces = { "application/json" }, method = RequestMethod.GET)
	public ResponseEntity<Employee> getEmployeeById(@PathVariable long id) {
		return ResponseEntity.ok().body(stackService.getEmployeeById(id));
	}
}