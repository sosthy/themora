package com.starstel.telcopro.stocks.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.starstel.telcopro.stocks.entities.Memory;

public interface MemoryRepository extends JpaRepository<Memory, Long>
{

}
