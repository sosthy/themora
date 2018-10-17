package com.starstel.telcopro.stocks.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.starstel.telcopro.stocks.entities.Emplacement;
import com.starstel.telcopro.stocks.entities.Mouvment;
import com.starstel.telcopro.stocks.entities.Portable;

public interface PortableRepository extends JpaRepository<Portable, Long> {
	@Query("SELECT mouvment FROM Mouvment mouvment WHERE mouvment.entrepotSource.id = :id")
	public List<Mouvment> getMouvments(@Param("id") Long id);
	
	@Query("SELECT emplacement FROM Emplacement emplacement, Portable portable WHERE portable.id = :id AND "
			+ "portable.stock.emplacement = emplacement")
	public Emplacement getEmplacement(@Param("id") Long id);
	
}
