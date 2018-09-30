package com.starstel.telcopro.accounts.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.starstel.telcopro.accounts.entities.AppUser;

public interface AppUserRepository extends JpaRepository<AppUser, Long> 
{
	public AppUser findByUsername(String username);
}
