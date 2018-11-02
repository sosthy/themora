package com.starstel.telcopro.accounts.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.starstel.telcopro.accounts.entities.AppUser;

public interface AppUserRepository extends JpaRepository<AppUser, Long> 
{
	@Query("select u from AppUser u where lower(u.username) like lower(?1)")
	public AppUser findByUsername(String username);
}
