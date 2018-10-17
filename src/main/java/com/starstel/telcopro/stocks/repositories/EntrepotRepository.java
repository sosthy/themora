package com.starstel.telcopro.stocks.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.starstel.telcopro.stocks.entities.Entrepot;
import com.starstel.telcopro.stocks.entities.Mouvment;
import com.starstel.telcopro.stocks.entities.Stock;

public interface EntrepotRepository extends JpaRepository<Entrepot, Long>
{
	@Query("SELECT stock FROM Stock stock WHERE stock.emplacement.entrepot.id = :id")
	public List<Stock> getAllStockOfEntrepot(@Param("id") Long id);
	
	@Query("SELECT mouvment FROM Mouvment mouvment WHERE mouvment.entrepotSource.id = :id")
	public List<Mouvment> getAllMouvmentOfEntrepot(@Param("id") Long id);
	
	@Query("SELECT COUNT(item) FROM PortableItem item WHERE item.portable.stock.emplacement.entrepot.id = :id")
	public Long getPortableItemCountOfEntrepot(@Param("id") Long id);
	
	@Query("SELECT COUNT(item) FROM PortableItem item WHERE item.portable.stock.emplacement.id = :id")
	public Long getPortableItemCountOfEmplacement(@Param("id") Long id);
}
