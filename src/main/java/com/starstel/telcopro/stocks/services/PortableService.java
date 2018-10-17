package com.starstel.telcopro.stocks.services;


import java.util.List;

import org.springframework.data.domain.Page;

import com.starstel.telcopro.stocks.entities.Emplacement;
import com.starstel.telcopro.stocks.entities.Mouvment;
import com.starstel.telcopro.stocks.entities.Portable;



public interface PortableService 
{
	Portable save(Portable portable);
	Boolean delete(Long id);
	List<Portable> getPortables();
	Portable getPortable(Long id);
	
	Emplacement getEmplacement(Long id);
	Mouvment getAllMouvment(Long id);

}
