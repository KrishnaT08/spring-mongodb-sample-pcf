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

@RestController
@RequestMapping(value = "/employees")
public class EmployeeController {
    private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);
    private CrudRepository<Employee, String> repository;

    @Autowired
    public EmployeeController(CrudRepository<Employee, String> repository) {
        this.repository = repository;
    }

    @RequestMapping(method = RequestMethod.GET)
    public Iterable<Employee> employees() {
        return repository.findAll();
    }

    @RequestMapping(method = RequestMethod.PUT)
    public Employee add(@RequestBody @Valid Employee employee) {
        logger.info("Adding employee " + employee.getId());
        return repository.save(employee);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Employee update(@RequestBody @Valid Employee employee) {
        logger.info("Updating employee " + employee.getId());
        return repository.save(employee);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Employee getById(@PathVariable String id) {
        logger.info("Getting employee " + id);
        return repository.findOne(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteById(@PathVariable String id) {
        logger.info("Deleting employee " + id);
        repository.delete(id);
    }
}