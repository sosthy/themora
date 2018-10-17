package com.starstel.telcopro.stocks.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.starstel.telcopro.stocks.entities.StockCategory;

public interface MemoryRepository extends JpaRepository<StockCategory, Long>
{

}
