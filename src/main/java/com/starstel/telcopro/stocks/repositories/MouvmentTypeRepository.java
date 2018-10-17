package com.starstel.telcopro.stocks.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.starstel.telcopro.stocks.entities.MouvmentType;

public interface MouvmentTypeRepository extends JpaRepository<MouvmentType, Long>
{

}
