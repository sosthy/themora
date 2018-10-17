package com.starstel.telcopro.stocks.services;

import java.util.List;
import java.util.Set;

import com.starstel.telcopro.stocks.entities.Mouvment;
import com.starstel.telcopro.stocks.entities.MouvmentType;

public interface MouvmentService 
{
	// MouvmentType
	List<MouvmentType> listMouvmentType();
	MouvmentType saveMouvmentType(MouvmentType mouvmentType);
	Boolean deleteMouvmentType(Long id);
	Set<Mouvment> getAllMouvmentOfMouvmentType(Long id);
	Set<Mouvment> getAllMouvmentOfEmployee(Long id);
	
	// Mouvment
	List<Mouvment> listMouvment();
	Mouvment saveMouvment(Mouvment mouvment);
	Boolean deleteMouvment(Long id);
}
