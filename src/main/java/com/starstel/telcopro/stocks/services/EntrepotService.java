package com.starstel.telcopro.stocks.services;

import java.util.List;
import java.util.Set;

import com.starstel.telcopro.stocks.entities.Emplacement;
import com.starstel.telcopro.stocks.entities.Entrepot;
import com.starstel.telcopro.stocks.entities.Mouvment;
import com.starstel.telcopro.stocks.entities.Product;
import com.starstel.telcopro.stocks.entities.Stock;

public interface EntrepotService 
{
	// Entrepot
	List<Entrepot> listEntrepot();
	Entrepot getEntrepot(Long id);
	Entrepot saveEntrepot(Entrepot entrepot);
	Boolean deleteEntrepot(Long id);
	
	List<Emplacement> listEmplacement();
	Emplacement getEmplacement(Long id);
	Emplacement saveEmplacement(Emplacement emplacement);
	Boolean deleteEmplacement(Long id);
	
	Set<Mouvment> getAllMouvmentOfEntrepot(Long id);
	List<Stock> getAllStockOfEntrepot(Long id);
	Long getStockCountOfEntrepot(Long id);
	Long getProductItemCountOfEntrepot(Long id);
	
	Set<Emplacement> getAllEmplacementOfEntrepot(Long id);
	Set<Stock> getAllStockOfEmplacement(Long id);
	Long getStockCountOfEmplacement(Long id);
	Long getProductItemCountOfEmplacement(Long id);

	Boolean isSpaced(Entrepot entrepot);
	Boolean isAddPossible(Entrepot entrepot, Product product);
	Boolean isAddPossible(Entrepot entrepot, Set<Product> product);
}
