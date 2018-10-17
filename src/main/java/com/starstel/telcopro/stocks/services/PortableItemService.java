package com.starstel.telcopro.stocks.services;


import java.util.Set;

import com.starstel.telcopro.stocks.entities.PortableItem;

//import com.starstel.telcopro.stock.entities.Product;

public interface PortableItemService 
{
	PortableItem save(PortableItem portableItem);
	Boolean delete(Long id);
	Set<PortableItem> getPortableItems();
	PortableItem getPortableItem(Long id);
}
