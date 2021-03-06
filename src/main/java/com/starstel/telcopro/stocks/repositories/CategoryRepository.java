package com.starstel.telcopro.stocks.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.starstel.telcopro.stocks.entities.ProductCategory;

public interface CategoryRepository extends JpaRepository<ProductCategory, Long>
{

}
