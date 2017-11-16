package com.samples.employee.web;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.samples.employee.domain.Employee;
import com.samples.employee.service.EmployeeService;

@RestController
@RequestMapping(value = "/employees")
public class EmployeeController {
	private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);
	private EmployeeService service;

	@Autowired
	public EmployeeController(EmployeeService service) {
		this.service = service;
	}

	@RequestMapping(method = RequestMethod.GET)
	public Iterable<Employee> employees() {
		return service.employees();
	}

	@RequestMapping(method = RequestMethod.PUT)
	public Employee add(@RequestBody @Valid Employee employee) {

		return service.add(employee);
	}

	@RequestMapping(method = RequestMethod.POST)
	public Employee update(@RequestBody @Valid Employee employee) {

		return service.update(employee);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Employee getById(@PathVariable String id) {

		return service.getById(id);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void deleteById(@PathVariable String id) {
		service.deleteById(id);
	}
}