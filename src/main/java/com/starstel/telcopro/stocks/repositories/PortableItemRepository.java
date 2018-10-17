package com.starstel.telcopro.stocks.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.starstel.telcopro.stocks.entities.PortableItem;

public interface PortableItemRepository extends JpaRepository<PortableItem, Long> {

}
