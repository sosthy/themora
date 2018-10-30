package com.starstel.telcopro.stocks.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.starstel.telcopro.stocks.entities.PortableCategory;

public interface PortableCategoryRepository extends JpaRepository<PortableCategory, Long>
{

}
