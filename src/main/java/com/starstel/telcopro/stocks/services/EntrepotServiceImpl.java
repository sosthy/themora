package com.starstel.telcopro.stocks.services;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.starstel.telcopro.stocks.entities.Emplacement;
import com.starstel.telcopro.stocks.entities.Entrepot;
import com.starstel.telcopro.stocks.entities.Mouvment;
import com.starstel.telcopro.stocks.entities.Stock;
import com.starstel.telcopro.stocks.repositories.EmplacementRepository;
import com.starstel.telcopro.stocks.repositories.EntrepotRepository;

@Service
public class EntrepotServiceImpl implements EntrepotService
{
	@Autowired
	private EntrepotRepository entrepotRepository;
	@Autowired
	private EmplacementRepository emplacementRepository;

	@Override
	public List<Entrepot> listEntrepot() 
	{
		return entrepotRepository.findAll();
	}

	@Override
	public Entrepot getEntrepot(Long id) 
	{
		return entrepotRepository.findById(id).get();
	}

	@Override
	public Entrepot saveEntrepot(Entrepot entrepot)
	{
		return entrepotRepository.save(entrepot);
	}

	@Override
	public Boolean deleteEntrepot(Long id) 
	{
		entrepotRepository.deleteById(id);
		return true;
	}

	@Override
	public List<Emplacement> listEmplacement() 
	{
		return emplacementRepository.findAll();
	}

	@Override
	public Emplacement getEmplacement(Long id) 
	{
		return emplacementRepository.findById(id).get();
	}

	@Override
	public Emplacement saveEmplacement(Emplacement emplacement) 
	{
		return emplacementRepository.save(emplacement);
	}

	@Override
	public Boolean deleteEmplacement(Long id) 
	{
		emplacementRepository.deleteById(id);
		return true;
	}

	@Override
	public Set<Mouvment> getAllMouvmentOfEntrepot(Long id) 
	{
		Entrepot entrepot = entrepotRepository.findById(id).get();
		
		if(entrepot != null)
			return entrepot.getMouvments();
		else
			return null;
	}

	@Override
	public List<Stock> getAllStockOfEntrepot(Long id) 
	{
		return entrepotRepository.getAllStockOfEntrepot(id);
	}

	@Override
	public Long getStockCountOfEntrepot(Long id) 
	{
		return Long.valueOf(entrepotRepository.getAllStockOfEntrepot(id).size());
	}

	@Override
	public Long getProductItemCountOfEntrepot(Long id) 
	{
		return entrepotRepository.getPortableItemCountOfEntrepot(id);
	}

	@Override
	public Set<Emplacement> getAllEmplacementOfEntrepot(Long id)
	{
		Entrepot entrepot = entrepotRepository.findById(id).get();
		
		if(entrepot != null)
			return entrepot.getEmplacements();
		else
			return null;
	}

	@Override
	public Set<Stock> getAllStockOfEmplacement(Long id) 
	{
		Emplacement emplacement = emplacementRepository.findById(id).get();
		
		if(emplacement != null)
			return emplacement.getStocks();
		else
			return null;
	}

	@Override
	public Long getStockCountOfEmplacement(Long id) 
	{
		Emplacement emplacement = emplacementRepository.findById(id).get();
		
		if(emplacement != null)
			return Long.valueOf(emplacement.getStocks().size());
		else
			return null;
	}

	@Override
	public Long getProductItemCountOfEmplacement(Long id)
	{
		return entrepotRepository.getPortableItemCountOfEmplacement(id);
	}
	
}
