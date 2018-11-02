package com.starstel.telcopro.stocks.services;

import java.util.List;
import java.util.Set;

import com.starstel.telcopro.stocks.entities.Mouvment;
import com.starstel.telcopro.stocks.entities.Product;
import com.starstel.telcopro.stocks.entities.Product;

public interface ProductService 
{
	List<Product> listProducts();
	Product saveProduct(Product product);
	Boolean deleteProduct(Long id);
	Product getProduct(Long id);
	List<Product> searchProducts(String keyWords);
	

	List<Mouvment> getAllMouvmentOfProduct(Long id);
	List<Mouvment> getAllMouvmentOfEmployee(Long id);
	
}
