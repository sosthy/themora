package com.starstel.telcopro.stocks.services;

import java.util.List;
import com.starstel.telcopro.stocks.entities.Stock;

public interface ProductService 
{
	List<Stock> listMouvmentType();
	Stock saveStock(Stock Stock);
	Boolean deleteStock(Long id);
}
