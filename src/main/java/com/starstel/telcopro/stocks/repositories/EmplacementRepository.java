package com.starstel.telcopro.stocks.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.starstel.telcopro.stocks.entities.Emplacement;

public interface EmplacementRepository extends JpaRepository<Emplacement, Long>
{

}
