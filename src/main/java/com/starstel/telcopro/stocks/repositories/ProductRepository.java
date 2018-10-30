package com.starstel.telcopro.stocks.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.starstel.telcopro.stocks.entities.Mouvment;
import com.starstel.telcopro.stocks.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long>
{
	@Query("select ml.mouvment from MouvmentLine ml where ml.product.id=:x")
	List<Mouvment> getAllMouvmentOfProduct(@Param("x") Long id);
	@Query("select m from Mouvment m")
	List<Mouvment> getAllMouvmentOfEmployee(Long id);
	
}