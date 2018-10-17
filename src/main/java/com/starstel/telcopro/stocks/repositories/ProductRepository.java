package com.starstel.telcopro.stocks.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.starstel.telcopro.stocks.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long>
{

}
