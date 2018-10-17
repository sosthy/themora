package com.starstel.telcopro.stocks.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.starstel.telcopro.stocks.entities.State;

public interface StateRepository extends JpaRepository<State, Long>
{

}
