package com.starstel.telcopro.accounts.restcontrollers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.starstel.telcopro.accounts.entities.AppMenu;
import com.starstel.telcopro.accounts.entities.AppRole;
import com.starstel.telcopro.accounts.entities.AppUser;
import com.starstel.telcopro.accounts.services.AccountService;
import com.starstel.telcopro.rh.services.EmployeeService;
import com.starstel.telcopro.rh.entities.Employee;


@CrossOrigin("*")
@RestController
public class AccountRestController 
{
	@Autowired
	private AccountService accountService;
	@Autowired
	private EmployeeService  employeeService;

	
	@RequestMapping(value = "/users-count", method = RequestMethod.GET)
	public Long listUsersCount() 
	{
		return accountService.usersCount();
	}
	
	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public List<AppUser> listUsers() 
	{
		return accountService.listAppUsers();
	}
	
	
	@RequestMapping(value = "/roles", method = RequestMethod.GET)
	public List<AppRole> listRoles() 
	{
		return accountService.listRoles();
	}
	
	@RequestMapping(value = "/roles-count", method = RequestMethod.GET)
	public Long listRolesCount() 
	{
		return accountService.rolesCount();
	}
	
	@RequestMapping(value = "/roles/{id}", method = RequestMethod.GET)
	public AppRole getRole(@PathVariable Long id)
	{
		return accountService.getRole(id);
	}
	
	@RequestMapping(value = "/roles", method = RequestMethod.POST)
	public AppRole createRole(@RequestBody AppRole role)
	{
		return accountService.createRole(role);
	}
	
	@RequestMapping(value = "/menus", method = RequestMethod.GET)
	public List<AppMenu> getAppMenus()
	{
		return accountService.getAppMenus();
	}
	
	@RequestMapping(value = "/menu/{id}", method = RequestMethod.GET)
	public AppMenu getMenu(@PathVariable Long id) {
	
		return accountService.getAppMenu(id);
	}
	
	@RequestMapping(value = "/menus", method = RequestMethod.POST)
	public AppMenu createRole(@RequestBody AppMenu appMenu)
	{
		return accountService.createAppMenu(appMenu);
	}
	
	@RequestMapping(value = "/create-user-account-employee", method = RequestMethod.POST)
	public AppUser createUser(@RequestBody Employee employee)
	{
		try {
			return accountService.createUserAccount(employee);
		} catch (Exception e) {
			throw new  RuntimeException("Nom d'utilisateur dupliqué.");
		}
	}
	
	@RequestMapping(value="/roles/{id}", method=RequestMethod.PUT)
	public AppRole editRole(@RequestBody AppRole role)
	{
		return accountService.editRole(role);
	}
	
	@RequestMapping(value="/roles/{id}", method=RequestMethod.DELETE)
	public boolean deleteRole(@PathVariable Long id)
	{
		return accountService.deleteRole(id);
	}
	
}
