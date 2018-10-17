package com.starstel.telcopro.stocks.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.starstel.telcopro.stocks.entities.Recipient;

public interface RecipientRepository extends JpaRepository<Recipient, Long>
{

}
