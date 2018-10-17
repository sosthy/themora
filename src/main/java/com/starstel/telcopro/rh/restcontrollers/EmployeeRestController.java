package com.starstel.telcopro.rh.restcontrollers;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.starstel.telcopro.rh.entities.Employee;
import com.starstel.telcopro.rh.services.EmployeeService;
import com.starstel.telcopro.stocks.entities.Mouvment;

@CrossOrigin("*")
@RestController
@RequestMapping("rh")
public class EmployeeRestController 
{
	@Autowired
	private EmployeeService employeeService;
	
	@RequestMapping(value="/employees", method = RequestMethod.GET)
	public List<Employee> getAllEmployee()
	{
		return employeeService.listEmployee();
	}
	
	@RequestMapping(value="/mouvment-of-employee/{id}", method = RequestMethod.GET)
	public Set<Mouvment> getAllMouvmentOfEmployee(@PathVariable Long id)
	{
		return employeeService.listMouvmentOfEmployee(id);
	}
}
