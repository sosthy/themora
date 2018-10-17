package com.starstel.telcopro.stocks.services;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import com.starstel.telcopro.stocks.entities.PortableItem;
import com.starstel.telcopro.stocks.repositories.PortableItemRepository;

public class PortableItemServiceImpl implements PortableItemService {

	@Autowired
	PortableItemRepository portableItemRepository;
	
	@Override
	public PortableItem save(PortableItem portableItem) {
		return portableItemRepository.save(portableItem);
	}

	@Override
	public Boolean delete(Long id) {
		portableItemRepository.deleteById(id);
		return true;
	}

	@Override
	public Set<PortableItem> getPortableItems() {
		return new HashSet<>(portableItemRepository.findAll());
	}

	@Override
	public PortableItem getPortableItem(Long id) {
		return portableItemRepository.findById(id).get();
	}

}
