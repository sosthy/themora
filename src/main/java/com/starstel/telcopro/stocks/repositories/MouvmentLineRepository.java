package com.starstel.telcopro.stocks.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.starstel.telcopro.stocks.entities.MouvmentLine;

public interface MouvmentLineRepository extends JpaRepository<MouvmentLine, Long>
{

}
