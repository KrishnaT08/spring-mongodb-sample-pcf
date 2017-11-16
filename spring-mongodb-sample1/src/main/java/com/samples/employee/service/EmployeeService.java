package com.samples.employee.service;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.samples.employee.domain.Employee;

@Service
public class EmployeeService {
    private static final Logger logger = LoggerFactory.getLogger(EmployeeService.class);
    private CrudRepository<Employee, String> repository;

    @Autowired
    public EmployeeService(CrudRepository<Employee, String> repository) {
        this.repository = repository;
    }

    @HystrixCommand()
    public Iterable<Employee> employees() {
        return repository.findAll();
    }

    @HystrixCommand()
    public Employee add(@RequestBody @Valid Employee employee) {
        logger.info("Adding employee " + employee.getId());
        return repository.save(employee);
    }

    @HystrixCommand()
    public Employee update(@RequestBody @Valid Employee employee) {
        logger.info("Updating employee " + employee.getId());
        return repository.save(employee);
    }

    @HystrixCommand()
    public Employee getById(@PathVariable String id) {
        logger.info("Getting employee " + id);
        return repository.findOne(id);
    }

    @HystrixCommand()
    public void deleteById(@PathVariable String id) {
        logger.info("Deleting employee " + id);
        repository.delete(id);
    }
}