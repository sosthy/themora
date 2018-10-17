package com.starstel.telcopro.stocks.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.starstel.telcopro.stocks.entities.Stock;

public interface StockRepository extends JpaRepository<Stock, Long>
{
	
}
