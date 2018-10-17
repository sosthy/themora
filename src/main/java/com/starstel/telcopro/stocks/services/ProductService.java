package com.starstel.telcopro.stocks.services;

import java.util.List;
import java.util.Set;

import com.starstel.telcopro.stocks.entities.Mouvment;
import com.starstel.telcopro.stocks.entities.Product;
import com.starstel.telcopro.stocks.entities.Stock;

public interface ProductService 
{
	List<Product> listProducts();
	Product saveProduct(Product product);
	Boolean deleteProduct(Long id);
	

	Set<Mouvment> getAllMouvmentOfProduct(Long id);
	Set<Mouvment> getAllMouvmentOfEmployee(Long id);
	
}
