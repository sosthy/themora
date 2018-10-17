package com.starstel.telcopro.stocks.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.starstel.telcopro.stocks.entities.Mouvment;

public interface MouvmentRepository extends JpaRepository<Mouvment, Long>
{

}
