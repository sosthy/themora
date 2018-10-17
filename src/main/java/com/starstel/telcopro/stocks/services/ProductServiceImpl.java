package com.starstel.telcopro.stocks.services;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.starstel.telcopro.stocks.entities.Mouvment;
import com.starstel.telcopro.stocks.entities.Product;
import com.starstel.telcopro.stocks.entities.Stock;
import com.starstel.telcopro.stocks.repositories.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService 
{

	@Autowired
	private ProductRepository productRepository;
	
	@Override
	public List<Product> listProducts() {
		return productRepository.findAll();
	}

	@Override
	public Product saveProduct(Product product) {
		return productRepository.save(product);
	}

	@Override
	public Boolean deleteProduct(Long id) {
		productRepository.deleteById(id);
		return true;
	}

	@Override
	public Set<Mouvment> getAllMouvmentOfProduct(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<Mouvment> getAllMouvmentOfEmployee(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
