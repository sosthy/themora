package com.starstel.telcopro.accounts.services;

import java.util.List;

import com.starstel.telcopro.accounts.entities.AppRole;
import com.starstel.telcopro.accounts.entities.AppUser;
import com.starstel.telcopro.rh.entities.Employee;

public interface AccountService 
{
	public List<Employee> listEmployee();
	public Employee getEmployee(Long id);
	public Employee createEmployee(Employee employee);
	public Employee editEmployee(Employee employee);
	public boolean deleteEmployee(Long id);
	public boolean lockEmployee(Long id);
	public boolean unlockEmployee(Long id);
	
	public List<AppRole> listRoles();
	public AppRole getRole(Long id);
	public AppRole createRole(AppRole role);
	public AppRole editRole(AppRole appRole);
	public boolean deleteRole(Long id);
	
	public AppUser findUserByUsername(String username);
	public Long usersCount();
	public Long rolesCount();
	
}
