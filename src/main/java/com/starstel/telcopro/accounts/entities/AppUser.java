
package com.starstel.telcopro.accounts.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.starstel.telcopro.rh.entities.Employee;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Sosthene Nouebissi
 */
@Entity
@Table(name = "appuser")
@Data @AllArgsConstructor @NoArgsConstructor
public class AppUser implements Serializable 
{
	@Id
	@SequenceGenerator(initialValue = 1, sequenceName = "USER_SEQ", allocationSize = 1, name = "user_id")
    @GeneratedValue(generator = "user_id")
    private Long id;
	
	@Column(unique = true)
	private String username;
    private String password;
    private String email;
    private Boolean lockStatus;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "appUser")
    private Employee employee;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<AppRole> roles = new ArrayList<>();

	public AppUser(String username, String password, String email, Boolean lockStatus) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
		this.lockStatus = lockStatus;
	}
    
    
}
