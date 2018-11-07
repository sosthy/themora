package com.starstel.telcopro.accounts.entities;

import java.util.ArrayList;
import java.util.List;

import com.starstel.telcopro.rh.entities.Employee;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class AppUserModel 
{	
	private Long id;
	private String username;
    private String password;
    private String email;
    private Boolean lockStatus;
    private Employee employee;
    private List<AppRole> roles = new ArrayList<>();
}
